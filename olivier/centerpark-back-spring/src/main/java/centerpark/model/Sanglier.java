package centerpark.model;

import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("Sanglier")
public class Sanglier extends Animal {

	public Sanglier() {}
	
	public Sanglier(String nom) {
		super(nom);
	}

	public Sanglier(Integer id,String nom) {
		super(id,nom);
	}

	@Override
	public String toString() {
		return "Sanglier [id=" + id + ", nom=" + nom + "]";
	}
	
	

	

	
	
}
