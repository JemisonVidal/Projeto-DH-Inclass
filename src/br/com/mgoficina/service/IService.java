package br.com.mgoficina.service;

import java.util.List;

import br.com.mgoficina.exceptions.DataIntegrityException;
import br.com.mgoficina.exceptions.DomainException;
import br.com.mgoficina.exceptions.ObjectNotFoundException;
import br.com.mgoficina.model.Client;

public interface IService<T> {

	public T create(T object) throws DomainException, DataIntegrityException;

	public T findById(Integer id) throws DomainException, ObjectNotFoundException;

	public List<T> findAll() throws ObjectNotFoundException;

	public T update(T oject) throws DomainException, DataIntegrityException, ObjectNotFoundException;

	public boolean delete(Integer id) throws DomainException, ObjectNotFoundException;

}