package br.com.mgoficina.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.mgoficina.exceptions.DataIntegrityException;
import br.com.mgoficina.exceptions.DomainException;
import br.com.mgoficina.exceptions.ObjectNotFoundException;
import br.com.mgoficina.model.Vehicle;
import br.com.mgoficina.service.IVehicleService;

public class VehicleServiceImpl implements IVehicleService {

	private List<Vehicle> vehicles = new ArrayList<>();

	private List<String> isValid(Vehicle vehicle) {
		List<String> listErrors = new ArrayList<String>();		
		if (vehicle.getId() == null)
			listErrors.add("Id");
		
		if (vehicle.getChassis() == null)
			listErrors.add("Chassis");

		if (vehicle.getColor() == null)
			listErrors.add("Color");

		if (vehicle.getLicensePlate() == null)
			listErrors.add("License Plate");

		if (vehicle.getModel() == null)
			listErrors.add("Model");

		if (vehicle.getTypeVehicle() == null)
			listErrors.add("Type Vehicle");

		if (vehicle.getYear() == null)
			listErrors.add("Year");

		return listErrors;
	}

	@Override
	public Vehicle create(Vehicle object) {
		List<String> listErrors = isValid(object);

		if (!listErrors.isEmpty()) {
			String fieldErrors = null;
			for (String field : listErrors) {
				fieldErrors += field;
			}
			throw new DataIntegrityException(fieldErrors);
		}

		this.vehicles.add(object);
		return object;
	}

	@Override
	public Vehicle findById(Integer id) {
		return this.vehicles.stream().filter(vehicle -> vehicle.getId() == id).findAny()
				.orElseThrow(() -> new ObjectNotFoundException("Vehicle :" + id));
	}

	@Override
	public Vehicle findByModel(String model) {
		return this.vehicles.stream().filter(vehicle -> vehicle.getModel() == model).findAny()
				.orElseThrow(() -> new ObjectNotFoundException("Vehicle :" + model));
	}

	@Override
	public List<Vehicle> findAll() {
		if (this.vehicles.isEmpty()) {
			throw new ObjectNotFoundException("Vehicles were not found");
		}
		return Collections.unmodifiableList(this.vehicles);
	}

	@Override
	public Vehicle update(Vehicle object) throws DomainException, DataIntegrityException, ObjectNotFoundException {
		if (object == null)
			throw new DataIntegrityException("vehicle cannot be null");

		int index = this.vehicles.indexOf(this.findById(object.getId()));
		if (index <= -1)
			throw new ObjectNotFoundException("Vehicle: " + object.getLicensePlate());

		this.vehicles.add(index, object);
		return this.vehicles.get(index);
	}

	@Override
	public boolean delete(Integer id) throws DomainException, ObjectNotFoundException {
		return this.vehicles.removeIf(vehicle -> vehicle.getId() == id);
	}

}
