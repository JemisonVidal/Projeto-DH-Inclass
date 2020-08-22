package br.com.mgoficina.service;

import java.util.List;

import br.com.mgoficina.model.Person;

public interface IPersonService {

	public Person create(Person person);
	public Person findPersonById(int id);
	public Person findPersonByName(String name);
	public List<Person> findAll();
	public boolean updatePerson(Person person);
	public boolean deletePerson(int id);
	
}