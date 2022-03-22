package centerpark.model;

import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("Serpent")
public class Serpent extends Animal {

	public Serpent() {}
	
	public Serpent(String nom) {
		super(nom);
	}

	public Serpent(Integer id,String nom) {
		super(id,nom);
	}

	@Override
	public String toString() {
		return "Serpent [id=" + id + ", nom=" + nom + "]";
	}
	
	
	
	

	
	
}
