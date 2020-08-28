package br.com.mgoficina;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.mgoficina.enums.Gender;
import br.com.mgoficina.enums.PaymentMethod;
import br.com.mgoficina.enums.Position;
import br.com.mgoficina.enums.TypeVehicle;
import br.com.mgoficina.model.Client;
import br.com.mgoficina.model.Employee;
import br.com.mgoficina.model.OrderService;
import br.com.mgoficina.model.Vehicle;
import br.com.mgoficina.service.impl.ClientServiceImpl;
import br.com.mgoficina.service.impl.EmployeeServiceImpl;
import br.com.mgoficina.service.impl.OrderServiceImpl;
import br.com.mgoficina.service.impl.VehicleServiceImpl;

public class Main {
	
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");			
		
		Client client = new Client(1, "João da Silva", "598.712.680-09", 19, Gender.Male);
		Client client2 = new Client(2, "José ", "598.712.680-09", 19, Gender.Male);
		
		Employee employee = new Employee(1, "José", "386.396.380-63", 25, Gender.Male, Position.MANAGER);
		Employee employee2 = new Employee(2, "Pedro", "386.396.380-63", 25, Gender.Male, Position.MECHANICAL);
		
		Vehicle vehicle = new Vehicle(1, "AAA", "ford", "2020", "1234", "blue", TypeVehicle.SEDAN);
		Vehicle vehicle2 = new Vehicle(2, "bbbb", "ford", "2020", "1234", "blue", TypeVehicle.SEDAN);
		
		List<Vehicle> vehicles = new ArrayList<>();
		vehicles.add(vehicle);
		client.setVehicles(vehicles);
		
		OrderService orderService = new OrderService(1, "Review", sdf.parse("27/08/2020"), null, 1500.0, PaymentMethod.DEBIT, client);
		OrderService orderService2 = new OrderService(2, "Review2", sdf.parse("27/08/2020"), null, 1500.0, PaymentMethod.CREDIT, client);
		
		ClientServiceImpl  clientService = new ClientServiceImpl();
		EmployeeServiceImpl  employeeService = new EmployeeServiceImpl(employee2);
		OrderServiceImpl  orderServiceService = new OrderServiceImpl();
		VehicleServiceImpl vehiService = new VehicleServiceImpl(); 
				
		clientService.create(client);		
		System.out.println(clientService.findById(1));
		clientService.create(client2);		
		System.out.println(clientService.findAll());
		
		employeeService.create(employee);
		System.out.println(employeeService.findById(1));
		employeeService.create(employee2);
		System.out.println(employeeService.findAll());
		
		vehiService.create(vehicle);
		System.out.println(vehiService.findById(1));
		
		vehiService.create(vehicle2);
		System.out.println(vehiService.findAll());			
		
		orderServiceService.create(orderService);		
		System.out.println(orderServiceService.findById(1));
		
		orderServiceService.create(orderService2);		
		System.out.println(orderServiceService.findAll());		
		
		orderServiceService.finishOrder(1);
		System.out.println(orderServiceService.findAll());
		
		employeeService.update(employee);//exception		
	}
}
