package br.com.mgoficina.service;

import java.util.List;

import br.com.mgoficina.exceptions.DataIntegrityException;
import br.com.mgoficina.exceptions.DomainException;
import br.com.mgoficina.exceptions.ObjectNotFoundException;
import br.com.mgoficina.model.Cliente;

public interface IClienteService {

	public Cliente create(Cliente cliente) throws DomainException, DataIntegrityException;
	public Cliente findClienteById(int indice) throws ObjectNotFoundException;
	public Cliente findClienteByNome(String nome) throws ObjectNotFoundException;
	public List<Cliente> findAll() throws ObjectNotFoundException;
	public boolean updateCliente(Cliente cliente) throws ObjectNotFoundException, DataIntegrityException;
	public boolean deleteCliente(int indice) throws ObjectNotFoundException;
	
}