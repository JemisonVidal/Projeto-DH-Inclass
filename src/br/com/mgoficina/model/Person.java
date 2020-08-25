package br.com.mgoficina.model;

import br.com.mgoficina.enums.Gender;

public abstract class Person {
	
	private Integer id;
	private String name;
	private String cpf;
	private int age;
	private Gender gender;
	
	public Person(Integer id, String name, String cpf, int age, Gender gender) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.age = age;
		this.gender = gender;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Client \n");
		sb.append("Id:    " + this.id + "\n");
		sb.append("Name:  " + this.name + "\n");
		sb.append("CPF:   " + this.name + "\n");
		sb.append("Age:   " + this.name + "\n");
		sb.append("Gender:" + this.name + "\n");
		return sb.toString();

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
