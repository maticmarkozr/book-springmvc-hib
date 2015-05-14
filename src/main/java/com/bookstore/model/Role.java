package com.bookstore.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Marcus
 *
 *Role model for different role account. Admin, User.
 */
@Entity
@Table(name="role")
public class Role extends AbstractBaseEntity{

	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 2476541772999529688L;
	
	@OneToOne
	private Account account;
	
	private Integer role;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}
	

}
