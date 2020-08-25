package br.com.mgoficina.model;

import br.com.mgoficina.enums.TypeVehicle;

public class Vehicle {
	
	private String licensePlate;
	private String model;
	private String year;
	private String chassis;
	private String color;
	private TypeVehicle typeVehicle;
	
	public Vehicle(String licensePlate, String model, String year, String chassis, String color,
			TypeVehicle typeVehicle) {
		super();
		this.licensePlate = licensePlate;
		this.model = model;
		this.year = year;
		this.chassis = chassis;
		this.color = color;
		this.typeVehicle = typeVehicle;
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
		return "Vehicle [licensePlate=" + licensePlate + ", model=" + model + ", year=" + year + ", chassis=" + chassis
				+ ", color=" + color + ", typeVehicle=" + typeVehicle.getDescription() + "]";
	}	
}
