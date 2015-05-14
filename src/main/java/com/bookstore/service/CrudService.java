package com.bookstore.service;

import java.util.List;

import com.bookstore.model.AbstractBaseEntity;

/**
 * @author Marcus
 *
 */
public interface CrudService <T extends AbstractBaseEntity>{
	
	/**
	 * Find end return entity whit passed id
	 * 
	 * @param id
	 * @return entity whit passed id or null if not found
	 */
	T findOne(Long id);
	
	/**
	 * 
	 * Return back all existing entities.
	 * 
	 * @return list of existing entities, empty list if there are no entities
	 */
	List<T>findAll();
	
	/**
	 * Save entity and return saved instance (with id set).
	 * @param t entity to save
	 * @return saved instance
	 */
	T save(T t);
	
	/**
	 * @param id
	 * @throws IllegalArgumentException
	 */
	void remove(Long id) throws IllegalArgumentException;
}
