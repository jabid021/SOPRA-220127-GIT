package centerpark.web.dto;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.format.annotation.DateTimeFormat;

import centerpark.model.Statut;

public class ReservationWeb {
	private Integer id;
	@Future
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	private Statut statut;
	private Integer idParticipant;
	private Integer idActivite;
	@Max(value = 10)
	@Min(value = 0)
	private Integer note;

	public ReservationWeb() {

	}

	public ReservationWeb(Integer id, LocalDate date, Statut statut, Integer idParticipant, Integer idActivite,
			Integer note) {
		super();
		this.id = id;
		this.date = date;
		this.statut = statut;
		this.idParticipant = idParticipant;
		this.idActivite = idActivite;
		this.note = note;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	public Integer getIdParticipant() {
		return idParticipant;
	}

	public void setIdParticipant(Integer idParticipant) {
		this.idParticipant = idParticipant;
	}

	public Integer getIdActivite() {
		return idActivite;
	}

	public void setIdActivite(Integer idActivite) {
		this.idActivite = idActivite;
	}

	public Integer getNote() {
		return note;
	}

	public void setNote(Integer note) {
		this.note = note;
	}

}
