package centerpark.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="safari")

public class Safari extends Activite {

	@ManyToOne
	@JoinColumn(name = "vehicule_fk")
	private Vehicule vehicule;
	@OneToMany(mappedBy = "safari")
	private List<Faune>rencontres;	
	
	public Safari() {
	}
	
	public Safari(Meteo meteo, LocalDate date, LocalTime heure, double prix,Vehicule vehicule,  List<Faune> rencontres) {
		super(meteo, date, heure, prix);
		this.vehicule=vehicule;
		this.rencontres=rencontres;
	}
	
	public Safari(Integer id,Meteo meteo, LocalDate date, LocalTime heure, double prix,Vehicule vehicule,  List<Faune> rencontres) {
		super(id,meteo, date, heure, prix);
		this.vehicule=vehicule;
		this.rencontres=rencontres;
	}
	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}
	
	public  List<Faune> getFaune() {
		return rencontres;
	}

	public void setFaune( List<Faune> rencontres) {
		this.rencontres = rencontres;
	}

	


	

	
}
