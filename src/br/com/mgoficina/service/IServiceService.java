package br.com.mgoficina.service;

import java.util.List;

import br.com.mgoficina.model.Service;

public interface IServiceService {

	public Service create(Service service);
	public Service findServiceById(int id);
	public Service findServiceByName(String name);
	public List<Service> findAll();
	public boolean updateService(Service service);
	public boolean deleteService(int id);
	
}