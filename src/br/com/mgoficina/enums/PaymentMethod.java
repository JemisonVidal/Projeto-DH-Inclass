package br.com.mgoficina.enums;

public enum PaymentMethod {
	
	DEBIT (1, "Debit"),
	CREDIT (2, "Credit"),
	CASH (3, "Cash");

	private int code;
	private String description;
	
	private PaymentMethod(int code, String description) {
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
