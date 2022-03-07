package model;

public class Pokemon {
	
	private Integer id;
	private String nom;
	private int attaque;
	private int pv;
	private Dresseur dresseur;
	private Type type;
	
	
	public Pokemon(String nom, int attaque, int pv, Type type) {
		this.nom = nom;
		this.attaque = attaque;
		this.pv = pv;
		this.type = type;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getAttaque() {
		return attaque;
	}


	public void setAttaque(int attaque) {
		this.attaque = attaque;
	}


	public int getPv() {
		return pv;
	}


	public void setPv(int pv) {
		this.pv = pv;
	}


	public Dresseur getDresseur() {
		return dresseur;
	}


	public void setDresseur(Dresseur dresseur) {
		this.dresseur = dresseur;
	}


	public Type getType() {
		return type;
	}


	public void setType(Type type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", nom=" + nom + ", attaque=" + attaque + ", pv=" + pv + ", dresseur=" + dresseur
				+ ", type=" + type + "]";
	}
	
	
	
	
	
	
	

}
