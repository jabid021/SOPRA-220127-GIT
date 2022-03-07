package heritageDemo.table;

import javax.persistence.Entity;

import model.Centre;

//@Entity
public class InfirmiereTable extends PersonneTable{

	private transient Centre centre;
	
	private String attributInfirmiere;
	

	public String getAttributInfirmiere() {
		return attributInfirmiere;
	}

	public void setAttributInfirmiere(String attributInfirmiere) {
		this.attributInfirmiere = attributInfirmiere;
	}

	
	
	
	public InfirmiereTable() {
	}
	
	public InfirmiereTable(String nom) {
		super(nom);
		
	}
	
	public Centre getCentre() {
		return centre;
	}

	public void setCentre(Centre centre) {
		this.centre = centre;
	}

	@Override
	public String toString() {
		return "Infirmiere [id=" + id + ", nom=" + nom + ", naissance=" + naissance + "]";
	}


}
