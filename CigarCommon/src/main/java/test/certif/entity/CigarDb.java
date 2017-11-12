package test.certif.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "cigar", schema = "", uniqueConstraints = @UniqueConstraint(columnNames = { "idcigar" }))
public class CigarDb  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1484843361760409277L;

	@Id
	@Column(name = "idcigar", nullable = false, unique = true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCigar;
	
	@Column(name = "cigarLabel", nullable = false, unique = false, length = 100)
	private String cigarLabel;
		
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="idcategory")
	private CategoryDb category;
	@Column(name = "description", nullable = true, unique = false, length = 512)
	private String description;
	
	@Column(name = "creationDate")
	@Temporal(TemporalType.DATE)
	private java.util.Date creationDate;
	
	/** Montant du compte **/
	@Column(name = "amount", nullable = false, unique = false)
	private BigDecimal amount;

	/** Montant du compte **/
	@Column(name = "leftCigar", nullable = false, unique = false)
	private Integer leftCigar;

	public Long getIdCigar() {
		return idCigar;
	}

	public void setIdCigar(Long idCigar) {
		this.idCigar = idCigar;
	}

	public String getCigarLabel() {
		return cigarLabel;
	}

	public void setCigarLabel(String cigarLabel) {
		this.cigarLabel = cigarLabel;
	}

	public CategoryDb getCategory() {
		return category;
	}

	public void setCategory(CategoryDb category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Integer getLeftCigar() {
		return leftCigar;
	}

	public void setLeftCigar(Integer leftCigar) {
		this.leftCigar = leftCigar;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCigar == null) ? 0 : idCigar.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CigarDb other = (CigarDb) obj;
		if (idCigar == null) {
			if (other.idCigar != null)
				return false;
		} else if (!idCigar.equals(other.idCigar))
			return false;
		return true;
	}
}
