package br.com.mgoficina;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import br.com.mgoficina.enums.Gender;
import br.com.mgoficina.enums.PaymentMethod;
import br.com.mgoficina.enums.Position;
import br.com.mgoficina.model.Client;
import br.com.mgoficina.model.Employee;
import br.com.mgoficina.model.OrderService;
import br.com.mgoficina.service.impl.EmployeeServiceImpl;
import br.com.mgoficina.service.impl.OrderServiceImpl;

public class Main {
	
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		EmployeeServiceImpl  employeeService = new EmployeeServiceImpl();
		OrderServiceImpl  orderServiceService = new OrderServiceImpl();
		
		Client client = new Client(1, "João da Silva", "598.712.680-09", 19, Gender.Male);
		OrderService orderService = new OrderService(1, "Review", sdf.parse("27/08/2020"), null, 1500.0, PaymentMethod.DEBIT, client);
		Employee employee = new Employee(1, "José", "386.396.380-63", 25, Gender.Male, Position.MANAGER);
		Employee employee2 = new Employee(2, "Jemison", "386.396.380-63", 25, Gender.Male, Position.MECHANICAL);
		
		
		//employeeService.create(employee);
		
		orderServiceService.create(orderService);
		orderServiceService.findAll();
		//orderServiceService.finishOrder(1);
		//orderServiceService.findAll();
		
		
	}
}
