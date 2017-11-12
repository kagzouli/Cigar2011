package test.certif.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "CREDITCARD", schema = "", uniqueConstraints = @UniqueConstraint(columnNames = { "idcreditcard" }))
public class CreditCard implements Serializable{

	private static final long serialVersionUID = 5748743108748196704L;
	
	@Id
	@Column(name = "idcreditcard", nullable = false, unique = true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCreditCard;
	
	@Column(name = "creditCardtype", nullable = false, unique = false, length = 100)
	private String creditCardType;
	
	@Column(name = "creditCardnumber", nullable = false, unique = false, length = 100)
	private String creditCardNumber;

	@Column(name = "EXPIRATIONDATE", nullable = false, unique = false, length = 8)
	private String expirationDate;
	
	public Long getIdCreditCard() {
		return idCreditCard;
	}

	public void setIdCreditCard(Long idCreditCard) {
		this.idCreditCard = idCreditCard;
	}

	public String getCreditCardType() {
		return creditCardType;
	}

	public void setCreditCardType(String creditCardType) {
		this.creditCardType = creditCardType;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

}
