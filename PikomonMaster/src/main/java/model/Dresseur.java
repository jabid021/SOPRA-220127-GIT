package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Dresseur extends Personne {

	@Embedded
	private Adresse adresse;
	
	@OneToOne(mappedBy = "maitre")
	private Arene arene;
	
	@OneToMany(mappedBy = "dresseur")
	private List<Pokemon> equipe;
	
	@ManyToMany
	@JoinTable(
			name="sac",
			joinColumns = @JoinColumn(name="owner"),
			inverseJoinColumns = @JoinColumn(name="consommable")
			)
	private List<Item> inventaire;
	
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
