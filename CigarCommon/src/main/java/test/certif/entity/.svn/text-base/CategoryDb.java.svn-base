package test.certif.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "category", schema = "", uniqueConstraints = @UniqueConstraint(columnNames = { "idcategory" }))
public class CategoryDb implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6443142392204186025L;

	@Id
	@Column(name = "idcategory", nullable = false, unique = true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCategory;
	
	@Column(name = "libelleCategorie", nullable = false, unique = false, length = 100)
	private String labelCategory;

	@Column(name = "description", nullable = true, unique = false, length = 512)
	private String description;
	
	@OneToMany(cascade=CascadeType.REMOVE,fetch=FetchType.LAZY)
	private List<CigarDb> listCigars;

	public Long getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}

	public String getLabelCategory() {
		return labelCategory;
	}

	public void setLabelCategory(String labelCategory) {
		this.labelCategory = labelCategory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<CigarDb> getListCigars() {
		return listCigars;
	}

	public void setListCigars(List<CigarDb> listCigars) {
		this.listCigars = listCigars;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCategory == null) ? 0 : idCategory.hashCode());
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
		CategoryDb other = (CategoryDb) obj;
		if (idCategory == null) {
			if (other.idCategory != null)
				return false;
		} else if (!idCategory.equals(other.idCategory))
			return false;
		return true;
	}
}
