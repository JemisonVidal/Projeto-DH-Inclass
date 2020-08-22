package br.com.mgoficina.model;

import java.util.ArrayList;
import java.util.List;

public class Client extends Person {
	
	private List<Vehicle> vehicles;

	public Client(int id, String name, String cpf, int age, char gender, List<Vehicle> vehicles) {
		super(id, name, cpf, age, gender);
		this.vehicles = new ArrayList<>(vehicles);
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	@Override
	public String toString() {
		return "Client [getId()=" + getId() + ", getName()=" + getName() + ", getCpf()="
				+ getCpf() + ", getAge()=" + getAge() + ", getGender()=" + getGender() + ", vehicles=" + vehicles + "]";
	}
}
