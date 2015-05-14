package com.bookstore.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bookstore.model.Account;
import com.bookstore.model.Role;
import com.bookstore.service.AccountService;

@Controller
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	AccountService accountService;
	
	/**
	 * Retrieve all accounts
	 * @return list of all accounts
	 * 
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ModelAttribute("accounts")
	public List<Account> get(){
		return accountService.findAll();
	}
	
	/**
	 * Return view for add/edit user
	 * @param model the model object map
	 * @return name of view for editing/adding user
	 */
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String getNew(Model model){
		model.addAttribute("account", new Account());
		
		return "addEditAccount";
	}
	
	/**
	 * Returns the view for editing account
	 * @param id
	 * @param model
	 * @return name of the view for add/edit account
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String getEdit(@PathVariable Long id, Model model){
		model.addAttribute("account", accountService.findOne(id));
		return "addEditAccount";
	}
	
	/**
	 * Remove account with specified id
	 * @param id
	 * @return view to accounts
	 */
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
	public String remove(@PathVariable Long id){
		accountService.remove(id);
		return "redirect:..";
	}
	
	/**
	 * Persist the account object
	 * @param account to persist
	 * @param br
	 * @param model
	 * @return if bd has no error redirect to view accounts, if does than to addEditAccount
	 */
	@RequestMapping(params = "save", method = RequestMethod.POST)
	public String post(@Valid Account account, BindingResult br, Model model){
		String viewName;
		
		if(!br.hasErrors() ){
			Role role = new Role();
			role.setRole("1");
			account.setRole(role);
			accountService.save(account);
			viewName = "redirect:accounts";
		} else{
			model.addAttribute("account", account);
			viewName = "addEditAccount"; 
		}
		return viewName;
	}
	
	/**
	 * cancel the new/edit account action
	 * @return redirect to book list
	 */
	@RequestMapping(params="cancel" ,method = RequestMethod.GET)
	public String cancel(){
		
		return "redirect:accounts";
	}
}
