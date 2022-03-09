package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Inheritance(strategy= InheritanceType.JOINED)
@Table(name="activite")
public abstract class Activite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_activite")
	protected Integer id;
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('Pluie','Soleil','Neige')")
	protected Meteo meteo;
	
	@Column(name="date_activite")
	protected LocalDate date;
	@Column(name="heure_activite")
	protected LocalTime heure;
	protected double prix;
	
	@OneToMany(mappedBy = "activite")
	protected List<Reservation> reservations;
	
	public Activite() {
	}
	
	public Activite(Meteo meteo, LocalDate date, LocalTime heure, double prix) {
		this.meteo = meteo;
		this.date = date;
		this.heure = heure;
		this.prix = prix;
	}

	public Activite(Integer id, Meteo meteo, LocalDate date, LocalTime heure, double prix) {
		this.meteo = meteo;
		this.date = date;
		this.heure = heure;
		this.prix = prix;
		this.id=id;
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
