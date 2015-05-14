package com.bookstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

/**
 * @author Marcus
 *
 */
@Entity
@Table(name = "category")
public class Category extends AbstractBaseEntity{
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2334667542950767769L;
	
	/**
	 * Name of the category
	 */
	@Pattern(regexp = "^(?=\\s*\\S).*$")
	@Column(nullable = false, length = 255)
	private String name;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
