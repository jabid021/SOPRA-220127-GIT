package model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
@Entity

public class Aquatique extends Activite{

public Aquatique() {
}	
	public Aquatique(Meteo meteo, LocalDate date, LocalTime heure, double prix) {
		super(meteo, date, heure, prix);
	}


	@Override
	public String toString() {
		return "Aquatique [id=" + id + ", meteo=" + meteo + ", date=" + date + ", heure=" + heure + ", prix=" + prix
				+ ", reservations=" + reservations + "]";
	}


}
