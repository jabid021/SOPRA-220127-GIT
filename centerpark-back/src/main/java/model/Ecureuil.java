package model;

public class Ecureuil extends Animal {

	public Ecureuil(String nom) {
		super(nom);
	}

	public Ecureuil(Integer id,String nom) {
		super(id,nom);
	}

	@Override
	public String toString() {
		return "Ecureuil [id=" + id + ", nom=" + nom + "]";
	}
	
	

	

	
	
}
