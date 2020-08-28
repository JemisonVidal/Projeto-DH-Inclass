package br.com.mgoficina.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.mgoficina.enums.Position;
import br.com.mgoficina.exceptions.DataIntegrityException;
import br.com.mgoficina.exceptions.DomainException;
import br.com.mgoficina.exceptions.ObjectNotFoundException;
import br.com.mgoficina.model.Employee;
import br.com.mgoficina.service.IEmployeeService;

public class EmployeeServiceImpl implements IEmployeeService {

	private Employee serviceCaller; 
	private List<Employee> employees = new ArrayList<>();

	public EmployeeServiceImpl(Employee serviceCaller) {
		this.serviceCaller = serviceCaller;
	}

	private List<String> isValid(Employee employee) {
		List<String> listErrors = new ArrayList<String>();
		if (employee.getAge() < 18)
			listErrors.add("Age");
		if (employee.getCpf().length() < 12)
			listErrors.add("Cpf");
		return listErrors;
	}

	@Override
	public Employee create(Employee object) {
		List<String> listErros = isValid(object);

		if (!listErros.isEmpty()) {
			String fieldErros = null;
			for (String field : listErros) {
				fieldErros += field;
			}
			throw new DataIntegrityException(fieldErros);
		}

		this.employees.add(object);
		return object;
	}

	@Override
	public Employee findById(Integer id) {
		return this.employees.stream()
				.filter(employee -> employee.getId() == id)
				.findAny()
				.orElseThrow(()-> new ObjectNotFoundException("Employee: "+ id));	
	}

	@Override
	public Employee findByName(String name) {
		return this.employees.stream()
				.filter(employee -> employee.getName() == name)
				.findAny()
				.orElseThrow(()-> new ObjectNotFoundException("Employee: "+ name));		
	}

	@Override
	public List<Employee> findAll() {
		if (this.employees.isEmpty())
			throw new ObjectNotFoundException("Employee");
		return Collections.unmodifiableList(this.employees);
	}

	@Override
	public Employee update(Employee object) {
		if (object == null)
			throw new DataIntegrityException("employee cannot be null");
		
		if(this.serviceCaller.getPosition() != Position.MANAGER)
			throw new DomainException("Only managers can perform this action");

		int index = this.employees.indexOf(this.findById(object.getId()));
		if (index <= -1)
			throw new ObjectNotFoundException("Employee: " + object.getName());

		this.employees.add(index, object);
		return this.employees.get(index);
	}	

	@Override
	public boolean delete(Integer id) {
		return this.employees.removeIf(employee -> employee.getId() == id);
	}	
}
