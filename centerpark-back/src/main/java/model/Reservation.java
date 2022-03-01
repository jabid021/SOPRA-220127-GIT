package model;

import java.time.LocalDate;

public class Reservation {
	
	private Integer id;
	private Activite activite;
	private Client client;
	private Participant participant;
	private Statut statut;
	private Integer note; //null au debut puis 0-10
	private LocalDate date;
	
	
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
	
	

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", activite=" + activite + ", participant=" + participant + ", statut="
				+ statut + ", note=" + note + ", date=" + date + "]";
	}


	
	
	
	
}
