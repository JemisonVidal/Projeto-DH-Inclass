package br.com.mgoficina.service;

import java.util.List;

import br.com.mgoficina.model.Vehicle;

public interface IVehicleService {

	public Vehicle create(Vehicle vehicle);
	public Vehicle findVehicleByLicensePlate(String licensePlate);
	public Vehicle findVehicleByModel(String model);
	public List<Vehicle> findAll();
	public boolean updateVehicle(Vehicle vehicle);
	public boolean deleteVehicle(String licensePlate);
}