package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Entity;


public class Safari extends Activite {

	private Vehicule vehicule;
	private List<Animal> rencontres;
	
	public Safari(Meteo meteo, LocalDate date, LocalTime heure, double prix,Vehicule vehicule, List<Animal> rencontres) {
		super(meteo, date, heure, prix);
		this.vehicule=vehicule;
		this.rencontres=rencontres;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}
	
	public List<Animal> getRencontres() {
		return rencontres;
	}

	public void setRencontres(List<Animal> rencontres) {
		this.rencontres = rencontres;
	}

	@Override
	public String toString() {
		return "Safari [vehicule=" + vehicule + ", rencontres=" + rencontres + ", id=" + id + ", meteo=" + meteo
				+ ", date=" + date + ", heure=" + heure + ", prix=" + prix + ", reservations=" + reservations + "]";
	}

	


	

	
}
