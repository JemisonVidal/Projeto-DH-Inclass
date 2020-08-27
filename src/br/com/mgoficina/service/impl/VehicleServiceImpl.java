package br.com.mgoficina.service.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.mgoficina.exceptions.DataIntegrityException;
import br.com.mgoficina.exceptions.ObjectNotFoundException;
import br.com.mgoficina.model.Vehicle;
import br.com.mgoficina.service.IVehicleService;

public class VehicleServiceImpl implements IVehicleService {

	private List<Vehicle> vehicles = new ArrayList<>();
	
	private List<String> isValid(Vehicle vehicle) {
		List<String> listErrors = new ArrayList<String>();
		if (vehicle.getChassis() == null) {
			listErrors.add("Chassis");
			return listErrors;
		} else if (vehicle.getColor() == null) {
			listErrors.add("Color");
			return listErrors;
		} else if (vehicle.getLicensePlate() == null) {
			listErrors.add("License Plate");
			return listErrors;
		} else if (vehicle.getModel() == null) {
			listErrors.add("Model");
			return listErrors;
		} else if (vehicle.getTypeVehicle() == null) {
			listErrors.add("Type Vehicle");
			return listErrors;
		} else if (vehicle.getYear() == null) {
			listErrors.add("Year");
			return listErrors;
		}		
		return listErrors;	
	}
		
	@Override
	public Vehicle create(Vehicle vehicle) {
		List<String> listErrors = isValid(vehicle);
		
		if (!listErrors.isEmpty()) {
			String fieldErrors = null;
			for (String field : listErrors) {
				fieldErrors += field;
			}
			throw new DataIntegrityException(fieldErrors);				
		}
		
		this.vehicles.add(vehicle);
		return vehicle;
	}

	@Override
	public Vehicle findVehicleByLicensePlate (String licensePlate) {
		for (Vehicle vehicle : this.vehicles) {
			if (vehicle.getLicensePlate().equals(licensePlate)) {
				return vehicle;
			}
		}
		throw new ObjectNotFoundException("Vehicle not found");
	}

	@Override
	public Vehicle findVehicleByModel(String model) {
		for (Vehicle vehicle : this.vehicles) {
			if (vehicle.getModel().equals(model)) {
				return vehicle;
			}
		}
		throw new ObjectNotFoundException("Vehicle not found");		
	}

	@Override
	public List<Vehicle> findAll() {
		if (this.vehicles.isEmpty()) {
			throw new ObjectNotFoundException("Vehicles were not found");
		}
		return this.vehicles;		
	}

	@Override
	public boolean updateVehicle(Vehicle vehicle) {
		int index = this.vehicles.indexOf(this.findVehicleByLicensePlate(vehicle.getLicensePlate()));
		
		if (index <= -1) {
			throw new ObjectNotFoundException("Vehicle found: " + vehicle.getLicensePlate());
		}		
		this.vehicles.remove(this.findVehicleByLicensePlate(vehicle.getLicensePlate()));
		this.vehicles.add(index, vehicle);
		return false;		
	}

	@Override
	public boolean deleteVehicle(String licensePlate) {
		for (Vehicle vehicle : this.vehicles) {
			if (vehicle.getLicensePlate().equals(licensePlate)) {
				return this.vehicles.remove(vehicle);
			}
		}
		throw new ObjectNotFoundException("Vehicle not found");
	}
}
