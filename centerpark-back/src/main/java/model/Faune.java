package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Faune {

	@ManyToOne
	@JoinColumn(name="animal_fk")
	private Animal animal;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_faune")
	private Integer id;
	@ManyToOne
	@JoinColumn(name="safari_fk")
	private Safari safari;
	
	public Faune() {
	}
	
	public Faune(Animal animal, Integer id, Safari safari) {
		this.animal = animal;
		this.id = id;
		this.safari = safari;
	}

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Safari getSafari() {
		return safari;
	}

	public void setSafari(Safari safari) {
		this.safari = safari;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	@Override
	public String toString() {
		return "Faune [animal=" + animal + ", id=" + id + ", safari=" + safari + "]";
	}

	
}
