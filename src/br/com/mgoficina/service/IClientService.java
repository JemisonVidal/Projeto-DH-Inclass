package br.com.mgoficina.service;

import java.util.List;

import br.com.mgoficina.exceptions.DataIntegrityException;
import br.com.mgoficina.exceptions.DomainException;
import br.com.mgoficina.exceptions.ObjectNotFoundException;
import br.com.mgoficina.model.Client;

public interface IClientService {

	public Client create(Client client) throws DomainException, DataIntegrityException;
	public Client findClienteById(Integer id) throws DomainException, ObjectNotFoundException;
	public Client findClienteByNome(String name) throws DomainException, ObjectNotFoundException;
	public List<Client> findAll() throws DomainException, ObjectNotFoundException;
	public boolean updateCliente(Client client) throws DomainException, DataIntegrityException, ObjectNotFoundException;
	public boolean deleteCliente(Integer id) throws DomainException, ObjectNotFoundException;
	
}