package model;

import java.util.List;

public class Client extends Compte {

	
	private String tel;
	private Adresse adresse;
	private List<Reservation> reservations;
	
	
	public Client(String mail, String password, String tel,String numero, String voie, String ville, String cp) {
		super(mail, password);
		this.tel = tel;
		this.adresse = new Adresse(numero,voie,ville,cp);
	}

	public Client(Integer id,String mail, String password, String tel,String numero, String voie, String ville, String cp) {
		super(id,mail, password);
		this.tel = tel;
		this.adresse = new Adresse(numero,voie,ville,cp);
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public Adresse getAdresse() {
		return adresse;
	}


	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}


	public List<Reservation> getReservations() {
		return reservations;
	}


	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}


	@Override
	public String toString() {
		return "Client [tel=" + tel + ", adresse=" + adresse + ", reservations=" + reservations + ", numero=" + numero
				+ ", mail=" + mail + ", password=" + password + "]";
	}


	

	
	
	
	
}