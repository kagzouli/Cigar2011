package test.certif.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "orders", schema = "", uniqueConstraints = @UniqueConstraint(columnNames = { "idorder" }))
public class Order implements Serializable{
	
	private static final long serialVersionUID = 1978298117784416354L;

	@Id
	@Column(name = "idorder", nullable = false, unique = true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idOrder;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="login")
	private Customer customer;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="idCreditCard")
	private CreditCard creditCard;
	
   @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="order")
	private List<CigarOrderLine> listCigarOrder;
	
	@Column(name = "totalAmount", nullable = false, unique = false)
	private BigDecimal totalAmount;

	public Long getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Long idOrder) {
		this.idOrder = idOrder;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	public List<CigarOrderLine> getListCigarOrder() {
		return listCigarOrder;
	}

	public void setListCigarOrder(List<CigarOrderLine> listCigarOrder) {
		this.listCigarOrder = listCigarOrder;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
}
