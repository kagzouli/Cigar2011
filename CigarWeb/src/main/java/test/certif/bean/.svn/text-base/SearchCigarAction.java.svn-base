package test.certif.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;

import test.certif.entity.CategoryDb;
import test.certif.entity.CigarDb;
import test.certif.service.client.ManageCigarDelegate;
import test.certif.service.manageproduct.IManageCigar;

public class SearchCigarAction extends AbstractAction {
	
	private String categorySelected;
	
  //  @EJB(name="ejb/manageCigar",beanName="ejb/manageCigar",mappedName="ejb/manageCigar")
//    private IManageCigar manageCigar;
	
	private List<SelectItem> listCategory = new ArrayList<SelectItem>();
	
	private List<CigarDb> listCigar = new ArrayList<CigarDb>();

	public String getCategorySelected() {
		return categorySelected;
	}

	public void setCategorySelected(String categorySelected) {
		this.categorySelected = categorySelected;
	}

	public List<SelectItem> getListCategory() {
		try {
			
			List<CategoryDb> listCategoryBus = ManageCigarDelegate.getInstance().findAllCategories();
		//     List<CategoryDb> listCategoryBus = manageCigar.findAllCategories();
			listCategory = new ArrayList<SelectItem>();
			if (listCategoryBus != null){
				for (CategoryDb categoryBus : listCategoryBus){
					listCategory.add(new SelectItem(categoryBus.getLabelCategory(),categoryBus.getLabelCategory()));
				}
			}
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return listCategory;
	}

	public void setListCategory(List<SelectItem> listCategory) {
		this.listCategory = listCategory;
	}
	
	public String doSearch(){
		try{
			this.listCigar = ManageCigarDelegate.getInstance().searchCigarsByCategoryLabel(categorySelected);
		}catch(Exception exception){
			exception.printStackTrace();
		}
		return "onSuccess"; 
	}
	
	

	public List<CigarDb> getListCigar() {
		return listCigar;
	}

	public void setListCigar(List<CigarDb> listCigar) {
		this.listCigar = listCigar;
	}
	
	public String logout(){
		return super.logout();
    }
}
