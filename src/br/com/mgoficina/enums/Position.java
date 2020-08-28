package br.com.mgoficina.enums;

public enum Position {
	
	MANAGER (1, "Manager"),
	ADMINISTRATIVE (2, "Administrative"),	
	MECHANICAL (3, "Mechanical");

	private int code;
	private String description;
	
	private Position(int code, String description) {
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
