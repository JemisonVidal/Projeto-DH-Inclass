package br.com.mgoficina.service;

import java.util.List;

import br.com.mgoficina.model.Vehicle;

public interface IVehicleService {

	public Vehicle create(Vehicle vehicle);
	public Vehicle findVehicleById(int id);
	public Vehicle findVehicleByName(String name);
	public List<Vehicle> findAll();
	public boolean updateVehicle(Vehicle vehicle);
	public boolean deleteVehicle(int id);
	
}