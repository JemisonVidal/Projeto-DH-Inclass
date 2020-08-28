package br.com.mgoficina.service;

public interface IPerson<T> {	
	public T findByName(String name);		
}