package formationSpring;

public interface Travailleur {
	String getNom();

	Departement getDepartement();

	Poste getPoste();

	void setNom(String nom);

	void setDepartement(Departement departement);

	void setPoste(Poste poste);
}
