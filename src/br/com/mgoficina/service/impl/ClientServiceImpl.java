package br.com.mgoficina.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.mgoficina.model.Client;
import br.com.mgoficina.service.IClientService;

public class ClientServiceImpl implements IClientService {

	private List<Client> clients;

	public ClientServiceImpl() {
		clients = new ArrayList<Client>();
	}

	public ClientServiceImpl(List<Client> clients) {
		this.clients = new ArrayList<>(clients);
	}

	@Override
	public Client create(Client cliente) {
		this.clients.add(cliente);
		return cliente;
	}

	@Override
	public Client findClientById(int id) {
		return null;
	}

	@Override
	public Client findClientByName(String name) {

		for (Client cliente : this.clients) {
			if (cliente.getName().equals(name)) {
				return cliente;
			}
		}

		return null;
	}

	@Override
	public List<Client> findAll() {
		return Collections.unmodifiableList(this.clients);
	}

	@Override
	public boolean updateClient(Client client) {

		if (this.clients.contains(client)) {

			int idexObject = this.clients.indexOf(client);
			this.clients.remove(client);
			this.clients.add(idexObject, client);
			return true;

		} else {

			return false;

		}
	}

	@Override
	public boolean deleteClient(int id) {
		return false;
	}

}
