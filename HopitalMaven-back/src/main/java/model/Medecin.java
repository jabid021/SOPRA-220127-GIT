package model;

import java.util.List;

public class Medecin extends Compte {

	private List<Visite> visites;
    private int salle;
    
    public Medecin(Integer id, String mail, String password) {
		super(id, mail, password);
 
	}


	public int getSalle() {
		return salle;
	}

	public void setSalle(int salle) {
		this.salle = salle;
	}
	


	public List<Visite> getVisites() {
		return visites;
	}


	public void setVisites(List<Visite> visites) {
		this.visites = visites;
	}


	@Override
	public String toString() {
		return "Medecin [salle=" + salle + ", id=" + id +"]";
	}



	



}
