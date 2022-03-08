package model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Centre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	private Infirmiere responsable;
	
	@OneToOne(mappedBy = "centre")
	private Ville ville;
	
	public Centre() {}
	
	public Centre(Infirmiere responsable) {
		this.responsable = responsable;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Infirmiere getResponsable() {
		return responsable;
	}

	public void setResponsable(Infirmiere responsable) {
		this.responsable = responsable;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Centre [id=" + id + ", responsable=" + responsable + "]";
	}
	
	
	

}
