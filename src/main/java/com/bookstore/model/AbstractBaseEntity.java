package com.bookstore.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


/**
 * @author Marcus
 *
 */
@MappedSuperclass
public abstract class AbstractBaseEntity implements Serializable{

	/**
	 * SerialVerisionUID
	 */
	private static final long serialVersionUID = -8998082569507670703L;
	
	/**
	 * PrimaryKey
	 */
	@Id
	@GeneratedValue
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode(){
		final int prime = 31;
		int result = 1;
		result = result * prime + ((id == null) ? 0 : id.hashCode());
		
		return result;
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object ob){
		if(this == ob){
			return true;
		}
		if(ob == null){
			return false;
		}
		if(getClass() != ob.getClass()){
			return false;
		}
		//TODO POJASNITI!!!!!!!!!!!!!!!!
		
		AbstractBaseEntity other = (AbstractBaseEntity) ob;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return false;
		
	}

}
