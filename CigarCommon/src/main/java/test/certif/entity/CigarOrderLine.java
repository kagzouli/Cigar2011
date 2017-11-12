package test.certif.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "CIGARORDERLINE", schema = "", uniqueConstraints = @UniqueConstraint(columnNames = { "idCigarOrderLine" }))
public class CigarOrderLine implements Serializable{

	private static final long serialVersionUID = 488223424053361059L;
	
	@Id
	@Column(name = "idcigarorderline", nullable = false, unique = true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Long idCigarOrderLine;
	
	@Column(name = "quantity", nullable = false, unique = false)
	private int quantity;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="idcigar")
	private CigarDb cigar;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="idorder")

	private Order order;
	
	public CigarOrderLine(){
		this.cigar = null;
		this.quantity = 0;
	}
	
	public CigarOrderLine(CigarDb cigar,int quantity){
		this.cigar    = cigar;
		this.quantity = quantity;
	}
	
	public Long getIdCigarOrderLine() {
		return idCigarOrderLine;
	}

	public void setIdCigarOrderLine(Long idCigarOrderLine) {
		this.idCigarOrderLine = idCigarOrderLine;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public CigarDb getCigar() {
		return cigar;
	}

	public void setCigar(CigarDb cigar) {
		this.cigar = cigar;
	}
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public BigDecimal getSubTotal(){
		return this.cigar.getAmount().multiply(BigDecimal.valueOf(this.quantity));
	}
	
	
}
