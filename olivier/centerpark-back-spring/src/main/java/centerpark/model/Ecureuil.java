package centerpark.model;

import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("Ecureuil")
public class Ecureuil extends Animal {

	public Ecureuil() {}
	
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
