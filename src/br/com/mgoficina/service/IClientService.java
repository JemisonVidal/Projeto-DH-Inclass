package br.com.mgoficina.service;

import java.util.List;

import br.com.mgoficina.exceptions.DataIntegrityException;
import br.com.mgoficina.exceptions.DomainException;
import br.com.mgoficina.exceptions.ObjectNotFoundException;
import br.com.mgoficina.model.Client;

public interface IClientService {

	public Client create(Client client) throws DomainException, DataIntegrityException;
	public Client findClientById(Integer id) throws DomainException, ObjectNotFoundException;
	public Client findClientByName(String name) throws DomainException, ObjectNotFoundException;
	public List<Client> findAll() throws ObjectNotFoundException;
	public Client updateClient(Client client) throws DomainException, DataIntegrityException, ObjectNotFoundException;
	public boolean deleteClient(Integer id) throws DomainException, ObjectNotFoundException;
	
}