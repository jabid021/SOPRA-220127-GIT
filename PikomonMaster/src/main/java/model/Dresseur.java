package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
public class Dresseur extends Personne {

	@Embedded
	private Adresse adresse;
	private transient Arene arene;
	private transient List<Pokemon> equipe;
	private transient List<Item> inventaire;
	
	public Dresseur() {}
	
	public Dresseur(String nom, LocalDate naissance,int numero, Ville ville) {
		super(nom,naissance);
		this.adresse = new Adresse(numero,ville);
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Arene getArene() {
		return arene;
	}

	public void setArene(Arene arene) {
		this.arene = arene;
	}

	public List<Pokemon> getEquipe() {
		return equipe;
	}

	public void setEquipe(List<Pokemon> equipe) {
		this.equipe = equipe;
	}

	public List<Item> getInventaire() {
		return inventaire;
	}

	public void setInventaire(List<Item> inventaire) {
		this.inventaire = inventaire;
	}

	@Override
	public String toString() {
		return "Dresseur [id=" + id + ", nom=" + nom + ", naissance=" + naissance + ", adresse=" + adresse
				+ ", inventaire=" + inventaire + "]";
	}
	
	
	

}
