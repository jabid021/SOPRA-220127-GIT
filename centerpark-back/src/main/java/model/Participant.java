package model;

public class Participant {
	private Integer id;
	private String nom;
	private String prenom;
	private int age;
	
	
	
	public Participant(String nom, String prenom, int age) {
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}
	
	public Participant(Integer id,String nom, String prenom, int age) {
		this.id=id;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Participant [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age + "]";
	}

	
	
	
	
	
	
}
