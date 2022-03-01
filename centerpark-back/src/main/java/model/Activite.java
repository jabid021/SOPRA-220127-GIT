package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public abstract class Activite {

	protected Integer id;
	protected Meteo meteo;
	protected LocalDate date;
	protected LocalTime heure;
	protected double prix;
	protected List<Reservation> reservations;
	
	
	public Activite(Meteo meteo, LocalDate date, LocalTime heure, double prix) {
		this.meteo = meteo;
		this.date = date;
		this.heure = heure;
		this.prix = prix;
	}

	

	public Activite(Integer id, Meteo meteo, LocalDate date, LocalTime heure, double prix) {
		this.id = id;
		this.meteo = meteo;
		this.date = date;
		this.heure = heure;
		this.prix = prix;
	}



	public Meteo getMeteo() {
		return meteo;
	}


	public void setMeteo(Meteo meteo) {
		this.meteo = meteo;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public LocalTime getHeure() {
		return heure;
	}


	public void setHeure(LocalTime heure) {
		this.heure = heure;
	}


	public double getPrix() {
		return prix;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}


	public List<Reservation> getReservations() {
		return reservations;
	}


	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	
}
