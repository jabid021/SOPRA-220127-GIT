package heritageDemo.joined;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import model.Centre;

//@Entity
@PrimaryKeyJoinColumn(name = "personne_fk")
public class InfirmiereJoined extends PersonneJoined{

	private transient Centre centre;
	private String attributInfirmiere;
	
	
	public String getAttributInfirmiere() {
		return attributInfirmiere;
	}

	public void setAttributInfirmiere(String attributInfirmiere) {
		this.attributInfirmiere = attributInfirmiere;
	}

	public InfirmiereJoined() {
	}
	
	public InfirmiereJoined(String nom) {
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
