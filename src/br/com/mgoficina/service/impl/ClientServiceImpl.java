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
		if (client.getVehicles() == null)
			listErrors.add("Vehicles");
		return listErrors;
	}

	@Override
	public Client create(Client object) {
//		List<String> listErros = isValid(object);
//
//		if (!listErros.isEmpty()) {
//			String fieldErros = null;
//			for (String field : listErros) {
//				fieldErros += field;
//			}
//			throw new DataIntegrityException(fieldErros);
//		}

		this.clients.add(object);
		return object;
	}

	@Override
	public Client findById(Integer id) {
		return this.clients.stream().filter(client -> client.getId() == id).findAny()
				.orElseThrow(() -> new ObjectNotFoundException("Client: " + id));
	}

	@Override
	public Client findByName(String name) {
		return this.clients.stream().filter(client -> client.getName() == name).findAny()
				.orElseThrow(() -> new ObjectNotFoundException("Client: " + name));
	}

	@Override
	public List<Client> findAll() {
		if (this.clients.isEmpty())
			throw new ObjectNotFoundException("Client");
		return Collections.unmodifiableList(this.clients);
	}

	@Override
	public Client update(Client object) {
		if (object == null)
			throw new DataIntegrityException("Client cannot be null");

		int index = this.clients.indexOf(this.findById(object.getId()));
		if (index <= -1)
			throw new ObjectNotFoundException("Client: " + object.getName());

		this.clients.add(index, object);
		return this.clients.get(index);
	}

	@Override
	public boolean delete(Integer id) {
		return this.clients.removeIf(client -> client.getId() == id);
	}
}
