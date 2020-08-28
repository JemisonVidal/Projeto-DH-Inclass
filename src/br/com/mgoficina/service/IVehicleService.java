package br.com.mgoficina.service;

import br.com.mgoficina.model.Vehicle;

public interface IVehicleService extends IService<Vehicle>{	
	public Vehicle findByModel(String model);
}