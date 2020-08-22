package br.com.mgoficina.service;

import java.util.List;

import br.com.mgoficina.model.Client;

public interface IClientService {

	public Client create(Client client);
	public Client findClientById(int id);
	public Client findClientByName(String name);
	public List<Client> findAll();
	public boolean updateClient(Client client);
	public boolean deleteClient(int id);
	
}