package test.certif.service.managecart;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.ejb.EJBException;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.resource.spi.endpoint.MessageEndpoint;

import test.certif.entity.CigarDb;
import test.certif.entity.CigarOrderLine;
import test.certif.entity.Order;

@MessageDriven(mappedName = "jms/topic/order")
public class EMailSenderBean implements MessageListener {

	@Override
	public void onMessage(Message message) {
		if (message == null) {
			throw new IllegalArgumentException("The message can't be null.");
		}

		try {
			Order order = (Order) ((ObjectMessage) message).getObject();
			sendEmail(order);
		} catch (JMSException exception) {
			exception.printStackTrace();
			throw new EJBException(exception);
		}

	}

	private void sendEmail(Order order) {
		Transport transport = null;
		try {
			System.out.println("Debut d'envoi du message");
			Properties properties = new Properties();
			properties.put("mail.smtp.host", "smtp.neuf.fr");
			properties.put("mail.smtp.auth", true);
			Session mailSession = Session.getInstance(properties, null);

			javax.mail.Message messageMail = new MimeMessage(mailSession);
			messageMail.setFrom(new InternetAddress("karim.gzouli@neuf.fr"));
			System.out.println("email : "+order.getCustomer().getEmail());
			messageMail.setRecipients(javax.mail.Message.RecipientType.TO, InternetAddress.parse(order.getCustomer().getEmail(),false));
			messageMail.setSentDate(new Date());
			messageMail.setSubject("[CigarStore] Confirmation : Order number "+order.getIdOrder());
			
			StringBuffer buffer = new StringBuffer();
			buffer.append("Your command contains \n\n :");
			List<CigarOrderLine> listCigarOrderLine = order.getListCigarOrder();
			if (listCigarOrderLine != null){
				for (CigarOrderLine cigarOrderLine : listCigarOrderLine){
					BigDecimal amount = cigarOrderLine.getCigar().getAmount();
					amount.setScale(2,2);
					BigDecimal subTotal = cigarOrderLine.getSubTotal();
					subTotal.setScale(2,2);
					buffer.append(cigarOrderLine.getCigar().getCigarLabel()).append("\t").append(amount).append("*").append(cigarOrderLine.getQuantity()).append("=").append(subTotal);
					buffer.append("\n");
					BigDecimal total = order.getTotalAmount();
					total.setScale(2,2);
					buffer.append("\t Total :"+total);
				}
			}
			messageMail.setText(buffer.toString());
			
			transport = mailSession.getTransport("smtp");
			transport.connect("smtp.neuf.fr", "karim.gzouli@neuf.fr", "mn8zy5fg");
			transport.sendMessage(messageMail, messageMail.getAllRecipients());
			
			System.out.println("Fin d'envoi du message");

		} catch (Exception exception) {
			throw new EJBException(exception);
		}finally{
			if (transport != null){
				try {
					transport.close();
				} catch (MessagingException e) {
					e.printStackTrace();
					throw new EJBException(e);
				}
			}
		}
	}

}
