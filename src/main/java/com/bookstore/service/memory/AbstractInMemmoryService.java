package com.bookstore.service.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import com.bookstore.model.AbstractBaseEntity;
import com.bookstore.service.CrudService;

/**
 * @author Marcus
 *
 * @param <T>
 */

public abstract class AbstractInMemmoryService <T extends AbstractBaseEntity> implements CrudService<T> {

	/**
	 * map for storage
	 */
	private final Map<Long, T> map = new HashMap<>();
	
	/**
	 * ID
	 */
	protected final AtomicLong seq = new AtomicLong(1);
	
	
	/* (non-Javadoc)
	 * @see com.bookstore.service.CrudService#findOne(java.lang.Long)
	 */
	@Override
	public T findOne(Long id){
		return map.get(id);
	}
	
	@Override
	public List<T> findAll(){
		return new ArrayList<>(map.values());
	}
	
	@Override
	public T save(T t){
		if(t.getId() == null){
			t.setId(seq.getAndIncrement());
		}
		map.put(t.getId(), t);
		return t;
		
	}
	
	@Override
	public void remove(Long id) throws IllegalArgumentException{
		T t = map.remove(id);
		if(t == null){
			throw new IllegalArgumentException(String.format("error: try to remove non-existing entity", id));
		}
	}
	
	
}
