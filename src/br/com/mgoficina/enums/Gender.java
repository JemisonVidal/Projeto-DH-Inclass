package br.com.mgoficina.enums;

public enum Gender {
	
	Male (1, "M"),
	Female (2, "F");	

	private int code;
	private String description;
	
	private Gender(int code, String description) {
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
