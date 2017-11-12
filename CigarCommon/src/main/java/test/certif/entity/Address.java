package test.certif.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "address", schema = "", uniqueConstraints = @UniqueConstraint(columnNames = { "idaddress" }))
public class Address implements Serializable{
	
	private static final long serialVersionUID = 4435946376340174890L;
	
	@Id
	@Column(name = "idAddress", nullable = false, unique = true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idAddress;

	@Column(name = "city", nullable = false, unique = false, length = 100)
	private String city;
	
	/** Temp **/
	@Column(name = "address", nullable = false, unique = false, length = 256)
	private String adress;

	
	public Integer getIdAddress() {
		return idAddress;
	}

	public void setIdAddress(Integer idAddress) {
		this.idAddress = idAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}
	
}
