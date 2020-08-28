package br.com.mgoficina.model;

import br.com.mgoficina.enums.TypeVehicle;

public class Vehicle {

	private Integer id;
	private String licensePlate;
	private String model;
	private String year;
	private String chassis;
	private String color;
	private TypeVehicle typeVehicle;

	public Vehicle(Integer id, String licensePlate, String model, String year, String chassis, String color,
			TypeVehicle typeVehicle) {
		super();
		this.id = id;
		this.licensePlate = licensePlate;
		this.model = model;
		this.year = year;
		this.chassis = chassis;
		this.color = color;
		this.typeVehicle = typeVehicle;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getChassis() {
		return chassis;
	}

	public void setChassis(String chassis) {
		this.chassis = chassis;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public TypeVehicle getTypeVehicle() {
		return typeVehicle;
	}

	public void setTypeVehicle(TypeVehicle typeVehicle) {
		this.typeVehicle = typeVehicle;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();		
		sb.append("Id:   " + this.getId() + "\n");
		sb.append("Plate:" + this.getLicensePlate() + "\n");
		sb.append("Color:" + this.getColor() + "\n");
		sb.append("Model:" + this.getModel() + "\n");
		sb.append("Year: " + this.getYear() + "\n");
		sb.append("Type: " + this.getTypeVehicle()+ "\n\n");
		
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
