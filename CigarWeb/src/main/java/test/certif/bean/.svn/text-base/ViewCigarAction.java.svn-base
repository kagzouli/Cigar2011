package test.certif.bean;

import test.certif.entity.CigarDb;
import test.certif.service.client.ManageCigarDelegate;

public class ViewCigarAction extends AbstractAction{
	
	private CigarDb cigar;
	
	public String selectCigar(){
		System.out.println("Je vois element");
		try{
			this.cigar = ManageCigarDelegate.getInstance().searchCigarById(this.getParamId("cigarId"));
			
		}catch(Exception exception){
			exception.printStackTrace();
		}
		
		return "selectElement";
	}
	
	public CigarDb getCigar() {
		return cigar;
	}

	public void setCigar(CigarDb cigar) {
		this.cigar = cigar;
	}
}
