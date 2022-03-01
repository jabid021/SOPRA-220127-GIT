package model;

public class Vehicule {
	private Integer id;
	private String model;

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

	@Override
	public String toString() {
		return "Vehicule [id=" + id + ", model=" + model + "]";
	}

	
	
	
}
