package com.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.model.Account;


/**
 * @author Marcus
 *
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
	
	
}
