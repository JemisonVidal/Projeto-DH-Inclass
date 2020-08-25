package br.com.mgoficina.model;

import java.util.ArrayList;
import java.util.List;

import br.com.mgoficina.enums.Gender;

public class Client extends Person {
	
	private List<Vehicle> vehicles  = new ArrayList<>();

	public Client(Integer id, String name, String cpf, int age, Gender gender) {
		super(id, name, cpf, age, gender);		
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Client \n");
		sb.append("Id:      " + this.getId() + "\n");
		sb.append("Name:    " + this.getName() + "\n");
		sb.append("CPF:     " + this.getCpf() + "\n");
		sb.append("Age:     " + this.getAge() + "\n");
		sb.append("Gender:  " + this.getGender() + "\n");
		sb.append("Vehicles:" + this.getVehicles() + "\n");
		return sb.toString();
	}
}
