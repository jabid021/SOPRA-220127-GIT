package centerpark.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="reservation")

public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_reservation")
	private Integer id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="date_reservation")
	private LocalDate date;
	
	private Integer note; //null au debut puis 0-10

	@ManyToOne
	@JoinColumn(name="activite_fk")
	private Activite activite;
	
	@ManyToOne
	@JoinColumn(name="client_fk")
	private Client client;
	
	@OneToOne
	@JoinColumn(name="participant_fk")
	private Participant participant;
	
	@Enumerated(EnumType.STRING)
	//@Column(columnDefinition = "ENUM('En_Cours','A_Venir','Termine')")
	private Statut statut;
	
	@Version
	private int version;

	public Reservation() {
	}	
	
	//insert
	public Reservation(Activite activite, Client client, Participant participant) {
		this.activite = activite;
		this.client = client;
		this.participant = participant;
		this.note=null;
		this.statut=Statut.A_Venir;
		this.date=LocalDate.now();	
	}
	
	//select
	public Reservation(Integer id,Activite activite, Client client, Participant participant,Integer note,Statut statut, LocalDate date) {
		this.id=id;
		this.activite = activite;
		this.client = client;
		this.participant = participant;
		this.note=note;
		this.statut=statut;
		this.date=date;	
	}


	public Activite getActivite() {
		return activite;
	}



	public void setActivite(Activite activite) {
		this.activite = activite;
	}



	public Client getClient() {
		return client;
	}



	public void setClient(Client client) {
		this.client = client;
	}



	public Participant getParticipant() {
		return participant;
	}



	public void setParticipant(Participant participant) {
		this.participant = participant;
	}



	public Statut getStatut() {
		return statut;
	}



	public void setStatut(Statut statut) {
		this.statut = statut;
	}


	public LocalDate getDate() {
		return date;
	}



	public void setDate(LocalDate date) {
		this.date = date;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public Integer getNote() {
		return note;
	}

	public void setNote(Integer note) {
		this.note = note;
	}
	
	

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", activite=" + activite + ", participant=" + participant + ", statut="
				+ statut + ", note=" + note + ", date=" + date + "]";
	}


	
	
	
	
}
