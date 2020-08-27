package br.com.mgoficina.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.mgoficina.exceptions.DataIntegrityException;
import br.com.mgoficina.exceptions.ObjectNotFoundException;
import br.com.mgoficina.model.Employee;
import br.com.mgoficina.service.IEmployeeService;

public class EmployeeServiceImpl implements IEmployeeService {

	private List<Employee> employees = new ArrayList<>();

	public EmployeeServiceImpl() {
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
	public Employee create(Employee employee) {
		List<String> listErros = isValid(employee);

		if (!listErros.isEmpty()) {
			String fieldErros = null;
			for (String field : listErros) {
				fieldErros += field;
			}
			throw new DataIntegrityException(fieldErros);
		}

		this.employees.add(employee);
		return employee;
	}

	@Override
	public Employee findEmployeeById(Integer id) {

		for (Employee employees : this.employees) {
			if (employees.getId().equals(id))
				return employees;
		}
		throw new ObjectNotFoundException("Employee: " + id);
	}

	@Override
	public Employee findEmployeeByName(String name) {
		for (Employee employee : this.employees) {
			if (employee.getName().toUpperCase().equals(name.toUpperCase()))
				return employee;
		}
		throw new ObjectNotFoundException("Employee: " + name);
	}

	@Override
	public List<Employee> findAll() {
		if (this.employees.isEmpty())
			throw new ObjectNotFoundException("Employee");
		return Collections.unmodifiableList(this.employees);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		int index = this.employees.indexOf(this.findEmployeeById(employee.getId()));

		if (index <= -1)
			throw new ObjectNotFoundException("Employee: " + employee.getName());

		this.employees.remove(this.findEmployeeById(employee.getId()));
		this.employees.add(index, employee);

		return this.employees.get(index);
	}

	@Override
	public boolean deleteEmployee(Integer id) {
		for (Employee employee : this.employees) {
			if (employee.getId().equals(id))
				return this.employees.remove(employee);
		}
		throw new ObjectNotFoundException("Employee: " + id);
	}
}
