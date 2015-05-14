package com.bookstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.model.Account;
import com.bookstore.repository.AccountRepository;
import com.bookstore.service.AccountService;

/**
 * @author Marcus
 *
 */
@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public Account findOne(Long id) {
		
		return accountRepository.findOne(id);
	}

	@Override
	public List<Account> findAll() {
		
		return accountRepository.findAll();
	}

	@Override
	@Transactional(readOnly=false)
	public Account save(Account account) {
		
		return accountRepository.save(account);
	}

	@Override
	@Transactional(readOnly = false)
	public void remove(Long id) throws IllegalArgumentException {
	
		Account account = accountRepository.findOne(id);
		if(account == null){
			throw new IllegalArgumentException("Account with id " + id + " does not exist.");
		}
		accountRepository.delete(account);
		
	}

}
