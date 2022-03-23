package centerpark.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "aquatique")

public class Aquatique extends Activite {

	public Aquatique() {
	}

	public Aquatique(Meteo meteo, LocalDate date, LocalTime heure, double prix) {
		super(meteo, date, heure, prix);
	}

	public Aquatique(Integer id, Meteo meteo, LocalDate date, LocalTime heure, double prix) {
		super(id, meteo, date, heure, prix);
	}

}
