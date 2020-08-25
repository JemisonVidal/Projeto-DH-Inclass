package br.com.mgoficina.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.mgoficina.exceptions.DataIntegrityException;
import br.com.mgoficina.exceptions.ObjectNotFoundException;
import br.com.mgoficina.model.Client;
import br.com.mgoficina.service.IClientService;

public class ClientServiceImpl implements IClientService {

	private List<Client> clients = new ArrayList<>();

	public ClientServiceImpl() {
	}

	private List<String> isValid(Client client) {
		List<String> listErrors = new ArrayList<String>();
		if (client.getAge() < 18)
			listErrors.add("Age");
		if (client.getCpf().length() < 12)
			listErrors.add("Cpf");
		return listErrors;
	}

	@Override
	public Client create(Client client) {
		List<String> listErros = isValid(client);

		if (!listErros.isEmpty()) {
			String fieldErros = null;
			for (String field : listErros) {
				fieldErros += field;
			}
			throw new DataIntegrityException(fieldErros);
		}

		this.clients.add(client);
		return client;
	}

	@Override
	public Client findClientById(Integer id) {

		for (Client client : this.clients) {
			if (client.getId().equals(id))
				return client;
		}
		throw new ObjectNotFoundException("Client: " + id);
	}

	@Override
	public Client findClientByName(String name) {
		for (Client client : this.clients) {
			if (client.getName().toUpperCase().equals(name.toUpperCase()))
				return client;
		}
		throw new ObjectNotFoundException("Client: " + name);
	}

	@Override
	public List<Client> findAll() {
		if (this.clients.isEmpty())
			throw new ObjectNotFoundException("Client");
		return Collections.unmodifiableList(this.clients);
	}

	@Override
	public Client updateClient(Client client) {
		int index = this.clients.indexOf(this.findClientById(client.getId()));

		if (index <= -1)
			throw new ObjectNotFoundException("Client: " + client.getName());

		this.clients.remove(this.findClientById(client.getId()));
		this.clients.add(index, client);

		return this.clients.get(index);
	}

	@Override
	public boolean deleteClient(Integer id) {
		for (Client client : this.clients) {
			if (client.getId().equals(id))
				return this.clients.remove(client);
		}
		throw new ObjectNotFoundException("Client: " + id);
	}

}
