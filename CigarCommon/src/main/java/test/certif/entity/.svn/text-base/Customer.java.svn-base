package test.certif.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "customer", schema = "", uniqueConstraints = @UniqueConstraint(columnNames = { "login" }))
public class Customer implements Serializable{
		
	private static final long serialVersionUID = 6443515837561651820L;

	@Id
	@Column(name = "login", nullable = false, unique = true)
	private String login;
	
	@Transient
	private String password;
	
	@Column(name = "nom", nullable = false, unique = false, length = 100)
	private String nom;
	
	@Column(name = "prenom", nullable = false, unique = false, length = 100)
	private String prenom;

	@Column(name = "email", nullable = false, unique = false, length = 100)
	private String email;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="idaddress")
	private Address address;
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
