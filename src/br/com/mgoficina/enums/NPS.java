package br.com.mgoficina.enums;

public enum NPS {
	
	BAD (1, "Bad"),
	GOOD (2, "Good"),	
	GREAT(3, "Great");

	private int code;
	private String description;
	
	private NPS(int code, String description) {
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
