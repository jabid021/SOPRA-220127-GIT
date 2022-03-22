package centerpark.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("staff")
public class Staff extends Compte {

	private String metier;
	
	public Staff() {}
	
	public Staff(String mail, String password,String metier) {
		super(mail, password);
		this.metier=metier;
	}
	
	public Staff(Integer id,String mail, String password,String metier) {
		super(id,mail, password);
		this.metier=metier;
	}

	public String getMetier() {
		return metier;
	}

	public void setMetier(String metier) {
		this.metier = metier;
	}

	@Override
	public String toString() {
		return "Staff [metier=" + metier + ", numero=" + numero + ", mail=" + mail + ", password=" + password + "]";
	}
	
	

	
	
	

}
