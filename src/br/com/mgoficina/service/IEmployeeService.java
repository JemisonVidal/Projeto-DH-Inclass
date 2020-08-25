package br.com.mgoficina.service;

import java.util.List;

import br.com.mgoficina.model.Employee;

public interface IEmployeeService {

	public Employee create(Employee employee);
	public Employee findEmployeeById(int id);
	public Employee findEmployeeByName(String name);
	public List<Employee> findAll();
	public boolean updateEmployee(Employee employee);
	public boolean deleteEmployee(int id);
	
}