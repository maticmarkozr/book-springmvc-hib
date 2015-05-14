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

import com.bookstore.model.Category;
import com.bookstore.service.CategoryService;

/**
 * @author Marcus
 *
 */
@Controller
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	/**
	 * Retrieves all categories and returns as model attribute
	 * 
	 * return list of all categories
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ModelAttribute("categories")
	public List<Category> get(){
		return categoryService.findAll();
	}
	
	
	/**
	 * 
	 * Returns the view for add new category. Adds empty category as model attribute
	 * 
	 * @param model
	 * @return the name of the view for adding/editing a category
	 */
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String getNew(Model model){
		model.addAttribute("category", new Category());
		return "addCatEdit";
	}
	
	/**
	 * Returns the view for editing a category. Adds category, found by passed
	 * id, as model attribute.
	 * @param id of category to edit
	 * @param model object map
	 * @return view for edit
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String getEdit(@PathVariable Long id,Model model){
		model.addAttribute("category", categoryService.findOne(id));
		return "addCatEdit";
	}
	/**
	 * Removes the category object with the specified id.
	 * @param id
	 * @return the redirect view name, which redirects to category list
	 */
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
	public String remove(@PathVariable Long id){
		categoryService.remove(id);
		return "redirect:..";
	}
	/**
	 * Persists the passed category object.
	 * @param cat to persist
	 * @param bd BindingResult the binding result
	 * @param model the model object map
	 * @return redirect view name
	 */
	@RequestMapping(params = "save", method = RequestMethod.POST)
	public String post(@Valid Category cat, BindingResult bd, Model model){
		String nameView;
		if(!bd.hasErrors()){
			categoryService.save(cat);
			nameView = "redirect:categories";
		} else {
			model.addAttribute("category", cat);
			nameView = "addCatEdit";
		}
		return nameView;
	}
	
	/**
	 * @return
	 */
	@RequestMapping(params = "cancel", method=RequestMethod.POST)
	public String cancel(){
		return "redirect:categories";
	}
}
