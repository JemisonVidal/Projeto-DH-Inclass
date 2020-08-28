package br.com.mgoficina.model;

import java.util.Date;

import br.com.mgoficina.enums.NPS;
import br.com.mgoficina.enums.PaymentMethod;

public class OrderService {

	private Integer id;
	private String serviceName;
	private Date serviceStartDate;
	private Date serviceEndDate;
	private double amount;
	private PaymentMethod paymentMethod;
	private Client client;
	private boolean finished;
	private NPS nps;

	public OrderService(Integer id, String serviceName, Date serviceStartDate, Date serviceEndDate, double amount,
			PaymentMethod paymentMethod, Client client) {
		this.id = id;
		this.serviceName = serviceName;
		this.serviceStartDate = serviceStartDate;
		this.serviceEndDate = serviceEndDate;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.client = client;
		this.finished = false;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Date getServiceStartDate() {
		return serviceStartDate;
	}

	public void setServiceStartDate(Date serviceStartDate) {
		this.serviceStartDate = serviceStartDate;
	}

	public Date getServiceEndDate() {
		return serviceEndDate;
	}

	public void setServiceEndDate(Date serviceEndDate) {
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
	
	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}
	
	public NPS getNps() {
		return nps;
	}

	public void setNps(NPS nps) {
		this.nps = nps;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();		
		sb.append("Id:          " + this.getId() + "\n");
		sb.append("Service Name:" + this.getServiceName() + "\n");
		sb.append("Client:      " + this.getClient() + "\n");
		sb.append("Finished:    " + this.isFinished() + "\n");
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
		OrderService other = (OrderService) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
