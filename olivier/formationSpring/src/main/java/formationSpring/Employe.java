package formationSpring;

public class Employe implements Travailleur{
	private String nom;
	
	private Departement departement;
	
	private Poste poste;
	
	public Employe() {
		
	}

	public Employe(String nom) {
		super();
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public Poste getPoste() {
		return poste;
	}

	public void setPoste(Poste poste) {
		this.poste = poste;
	}
	
}
