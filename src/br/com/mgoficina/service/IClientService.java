package br.com.mgoficina.service;

import br.com.mgoficina.exceptions.DomainException;
import br.com.mgoficina.exceptions.ObjectNotFoundException;
import br.com.mgoficina.model.Client;

public interface IClientService extends IService<Client> {
	public Client findClientByName(String name) throws DomainException, ObjectNotFoundException;
}