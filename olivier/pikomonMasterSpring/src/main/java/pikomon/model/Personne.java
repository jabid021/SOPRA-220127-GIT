package pikomon.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(name = "seqPersonneJPA",sequenceName = "seqPersonne")
public abstract class Personne {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seqPersonneJPA")
	protected Integer id;
	protected String nom;
	protected LocalDate naissance;
	
	public Personne() {}	
	
	public Personne(String nom) {
		this.nom = nom;
	}

	public Personne(String nom,LocalDate naissance) {
		this.nom = nom;
		this.naissance=naissance;
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

	public LocalDate getNaissance() {
		return naissance;
	}

	public void setNaissance(LocalDate naissance) {
		this.naissance = naissance;
	}
	
	
	
	
}
