package com.bookstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name = "username", nullable = false) 
	private Account account;
	
	@Column(name = "role", nullable = false, length = 45)  
	private String role;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	

}
