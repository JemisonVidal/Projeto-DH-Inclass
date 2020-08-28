package br.com.mgoficina.model;

import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.List;

import br.com.mgoficina.enums.Gender;
import br.com.mgoficina.enums.Position;

public class Employee extends Person {
	
	private Position position;
	private List<Service> services = new ArrayList<>();
	
	public Employee(int id, String name, String cpf, int age, Gender gender, Position position) {
		super(id, name, cpf, age, gender);
		this.position = position;		
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();		
		sb.append("Id:      " + this.getId() + "\n");
		sb.append("Name:    " + this.getName() + "\n");
		sb.append("CPF:     " + this.getCpf() + "\n");
		sb.append("Age:     " + this.getAge() + "\n");
		sb.append("Gender:  " + this.getGender() + "\n");
		sb.append("Position:" + this.getPosition() + "\n\n");
		
		return sb.toString();
	}
}
