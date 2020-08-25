package br.com.mgoficina.enums;

public enum TypeVehicle {
	
	SUV(1, "SUV"), 
	SPORT(2, "Sport"),
	SEDAN(3, "Sedan"), 
	HAT(4, "Hat");
	
	private int code;
	private String description;
	
	private TypeVehicle(int code, String description) {
		this.code = code;
		this.description = description;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
