package model;

public class Infirmiere extends Personne{

	private Centre centre;
	
	public Infirmiere(String nom) {
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
