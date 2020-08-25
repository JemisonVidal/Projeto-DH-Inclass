package br.com.mgoficina.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.mgoficina.exceptions.DataIntegrityException;
import br.com.mgoficina.model.Client;
import br.com.mgoficina.service.IClientService;

public class ClientServiceImpl implements IClientService {

	private List<Client> clients = new ArrayList<>();

	public ClientServiceImpl() {		
	}
	
	private List<String> isValid(Client client) {
		List<String> listErrors = new ArrayList<String>();
		if(client.getAge() < 18) listErrors.add("Age"); 		
		return listErrors;		
	}
	

	@Override
	public Client create(Client client) {
		List<String> listErros = isValid(client);
		
		if(!listErros.isEmpty()) {
			String fieldErros = null;
			for(String field: listErros) {
				fieldErros += field;				
			}			
			throw new DataIntegrityException(fieldErros);
		}
		
		this.clients.addAll(Arrays.asList(client));
		return client;		
	}

	@Override
	public Client findClienteById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client findClienteByNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateCliente(Client cliente) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCliente(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

}
