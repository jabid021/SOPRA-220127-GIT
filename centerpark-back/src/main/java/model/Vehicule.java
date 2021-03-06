package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="vehicule")

public class Vehicule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_vehicule")
	private Integer id;
	private String model;
	
	
	@Version
	private int version;

	public Vehicule() {
	}
	
	public Vehicule(String model) {
		this.model = model;
	}

	public Vehicule(Integer id,String model) {
		this.id=id;
		this.model = model;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
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
	public String toString() {
		return "Vehicule [id=" + id + ", model=" + model + ", version=" + version + "]";
	}

	



}
