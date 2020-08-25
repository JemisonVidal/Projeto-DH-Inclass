package br.com.mgoficina.model;

import java.security.Provider.Service;
import java.util.List;

import br.com.mgoficina.enums.Gender;

public class Employee extends Person {
	
	private String position;
	private List<Service> services;
	
	public Employee(int id, String name, String cpf, int age, Gender gender, String position, List<Service> services) {
		super(id, name, cpf, age, gender);
		this.position = position;
		this.services = services;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
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
		return "Employee [getId()=" + getId() + ", getName()="
				+ getName() + ", getCpf()=" + getCpf() + ", getAge()=" + getAge() + ", getGender()=" + getGender() + ", position=" + position + ", services=" + services + "]";
	}
}
