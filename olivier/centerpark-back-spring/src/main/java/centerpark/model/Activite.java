package centerpark.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

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
import javax.persistence.Version;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
@Table(name="activite")
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,include = JsonTypeInfo.As.PROPERTY,property = "type")
@JsonSubTypes({
	@Type(value=Safari.class,name="safari"),
	@Type(value=Aquatique.class,name="aquatique")
})
public abstract class Activite {

	@JsonView(JsonViews.Common.class)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_activite")
	protected Integer id;
	@JsonView(JsonViews.Common.class)
	@Enumerated(EnumType.STRING)
	//@Column(columnDefinition = "ENUM('Pluie','Soleil','Neige')")
	protected Meteo meteo;
	@JsonView(JsonViews.Common.class)
	@Column(name="date_activite")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	protected LocalDate date;
	@JsonView(JsonViews.Common.class)
	@Column(name="heure_activite")
	protected LocalTime heure;
	@JsonView(JsonViews.Common.class)
	protected double prix;
	
	@OneToMany(mappedBy = "activite")
	protected List<Reservation> reservations;
	@Version
	private int version;

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

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Activite other = (Activite) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
