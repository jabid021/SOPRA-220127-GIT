package heritageDemo.single;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import model.Adresse;
import model.Arene;
import model.Item;
import model.Pokemon;
import model.Ville;

//@Entity
@DiscriminatorValue("dresseur")
public class DresseurSingle extends PersonneSingle {

	private transient Adresse adresse;
	private transient Arene arene;
	private transient List<Pokemon> equipe;
	private transient List<Item> inventaire;
	private String attributDresseur;
	
	public DresseurSingle() {}
	
	public DresseurSingle(String nom, LocalDate naissance,int numero, Ville ville) {
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


	public String getAttributDresseur() {
		return attributDresseur;
	}

	public void setAttributDresseur(String attributDresseur) {
		this.attributDresseur = attributDresseur;
	}

	@Override
	public String toString() {
		return "Dresseur [id=" + id + ", nom=" + nom + ", naissance=" + naissance + ", adresse=" + adresse
				+ ", inventaire=" + inventaire + "]";
	}
	
	
	

}
