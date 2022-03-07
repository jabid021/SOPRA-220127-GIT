package heritageDemo.single;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import model.Centre;

//@Entity
@DiscriminatorValue("infirmiere")
public class InfirmiereSingle extends PersonneSingle{

	private transient Centre centre;
	private String attributInfirmiere;
	
	public InfirmiereSingle() {
	}
	
	public InfirmiereSingle(String nom) {
		super(nom);
		
	}
	
	public Centre getCentre() {
		return centre;
	}

	public void setCentre(Centre centre) {
		this.centre = centre;
	}
	
	
	

	public String getAttributInfirmiere() {
		return attributInfirmiere;
	}

	public void setAttributInfirmiere(String attributInfirmiere) {
		this.attributInfirmiere = attributInfirmiere;
	}

	@Override
	public String toString() {
		return "Infirmiere [id=" + id + ", nom=" + nom + ", naissance=" + naissance + "]";
	}


}
