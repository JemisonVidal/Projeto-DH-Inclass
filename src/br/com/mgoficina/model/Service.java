package br.com.mgoficina.model;

import br.com.mgoficina.enums.PaymentMethod;

public class Service {
	
	private String serviceName;
	private String serviceStartDate;
	private String serviceEndDate;
	private double amount;
	private PaymentMethod paymentMethod;
	private Client client;
	
	public Service(String serviceName, String serviceStartDate, String serviceEndDate, double amount,
			PaymentMethod paymentMethod, Client client) {
		this.serviceName = serviceName;
		this.serviceStartDate = serviceStartDate;
		this.serviceEndDate = serviceEndDate;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.client = client;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceStartDate() {
		return serviceStartDate;
	}

	public void setServiceStartDate(String serviceStartDate) {
		this.serviceStartDate = serviceStartDate;
	}

	public String getServiceEndDate() {
		return serviceEndDate;
	}

	public void setServiceEndDate(String serviceEndDate) {
		this.serviceEndDate = serviceEndDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Service [serviceName=" + serviceName + ", serviceStartDate=" + serviceStartDate + ", serviceEndDate="
				+ serviceEndDate + ", amount=" + amount + ", paymentMethod=" + paymentMethod.getDescription() + ", client=" + client
				+ "]";
	}
}
