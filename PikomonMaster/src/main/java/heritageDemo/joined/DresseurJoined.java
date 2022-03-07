package heritageDemo.joined;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import model.Adresse;
import model.Arene;
import model.Item;
import model.Pokemon;
import model.Ville;

//@Entity
@PrimaryKeyJoinColumn(name = "personne_fk")
public class DresseurJoined extends PersonneJoined {

	private transient Adresse adresse;
	private transient Arene arene;
	private transient List<Pokemon> equipe;
	private transient List<Item> inventaire;
	private String attributDresseur;
	
	
	
	public String getAttributDresseur() {
		return attributDresseur;
	}

	public void setAttributDresseur(String attributDresseur) {
		this.attributDresseur = attributDresseur;
	}

	public DresseurJoined() {}
	
	public DresseurJoined(String nom, LocalDate naissance,int numero, Ville ville) {
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
