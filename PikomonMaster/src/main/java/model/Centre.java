package model;

public class Centre {
	
	private Integer id;
	private Infirmiere responsable;
	private Ville ville;
	
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
