package model;

public abstract class Compte {
	
	protected Integer numero;
	protected String mail;
	protected String password;
	
	
	
	public Compte(Integer numero,String mail, String password) {
		this.numero=numero;
		this.mail = mail;
		this.password = password;
	}
	
	
	public Compte(String mail, String password) {
		this.mail = mail;
		this.password = password;
	}


	public Integer getNumero() {
		return numero;
	}


	public void setNumero(Integer numero) {
		this.numero = numero;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
}
