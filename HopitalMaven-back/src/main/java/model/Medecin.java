package model;

public class Medecin extends Compte {

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


	@Override
	public String toString() {
		return "Medecin [salle=" + salle + ", id=" + id +"]";
	}



	



}
