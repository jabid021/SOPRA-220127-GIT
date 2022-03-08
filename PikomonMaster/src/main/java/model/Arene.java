package model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Arene {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private int ordre;
	@Enumerated(EnumType.STRING)
	private Type type;
	
	@OneToOne
	private  Ville ville;
	@OneToOne
	private  Dresseur maitre;
	
	public Arene() {
	}
	
	public Arene(int ordre, Type type, Ville ville, Dresseur maitre) {
		this.ordre = ordre;
		this.type = type;
		this.ville = ville;
		this.maitre = maitre;
	}

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public int getOrdre() {
		return ordre;
	}



	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}



	public Type getType() {
		return type;
	}



	public void setType(Type type) {
		this.type = type;
	}



	public Ville getVille() {
		return ville;
	}



	public void setVille(Ville ville) {
		this.ville = ville;
	}



	public Dresseur getMaitre() {
		return maitre;
	}



	public void setMaitre(Dresseur maitre) {
		this.maitre = maitre;
	}

	@Override
	public String toString() {
		return "Arene [id=" + id + ", ordre=" + ordre + ", type=" + type + ", ville=" + ville + ", maitre=" + maitre
				+ "]";
	}
	
	
	
}
