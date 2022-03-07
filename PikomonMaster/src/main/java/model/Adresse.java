package model;

public class Adresse {

	private int numero;
	private Ville ville;
	
	
	public Adresse(int numero, Ville ville) {
		this.numero = numero;
		this.ville = ville;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public Ville getVille() {
		return ville;
	}


	public void setVille(Ville ville) {
		this.ville = ville;
	}


	@Override
	public String toString() {
		return "Adresse [numero=" + numero + ", ville=" + ville + "]";
	}
	

	
}
