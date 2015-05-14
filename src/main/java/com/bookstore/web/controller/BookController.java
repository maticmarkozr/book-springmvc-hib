package com.bookstore.web.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bookstore.model.Book;
import com.bookstore.model.Category;
import com.bookstore.service.BookService;
import com.bookstore.service.CategoryService;
import com.bookstore.web.validator.BookValidator;



@Controller
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private BookValidator userValidator;
	
	
	
	/**
	 * Get all books per category and returns them as model attrubute
	 * @return list of questions per category as model attribute
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ModelAttribute("books")
	public Map<String, List<Book>> get(){
		
		Map<String, List<Book>> retValue = new LinkedHashMap<String, List<Book>>();
		List<Category> categories = categoryService.findAll();
		
		
		for(Category c:categories){
			List <Book> books = bookService.findByCategory(c);
			if(!books.isEmpty()){
				retValue.put(c.getName(), books);
			}
		}
		
		//List<Book> uncategoriezedBooks = bookService.findAll();
		
//		for (Category c : categories) {
//			List<Book> books = bookService.findByCategory(c);
//			
//			if(!books.isEmpty()){
//				uncategoriezedBooks.removeAll(books);
//				retValue.put(c.getName(), books);
//			}
//			
//		}
		//books without category TOOOOOOOOOOOOODDDDDDDDDDDOOOOOOOOOOOOOO
//		if(!uncategoriezedBooks.isEmpty()){
//			retValue.put("Uncategorised", uncategoriezedBooks);
//		}
		
		return retValue;
		
	}
	
	/**
	 * Returns the view for adding new book. Adds empty book as model
	 * attribute <code>book</code> and list of all categories as model
	 * attribute <code>categories</code>.
	 * 
	 * @param model
	 * @return name of the view for adding/editing a books
	 */
	@RequestMapping(value="new", method = RequestMethod.GET)
	public String getNew(Model model){
		model.addAttribute("book", new Book());
		model.addAttribute("categories", categoryService.findAll());
		return "addBookEdit";
		
	}
	
	/**
	 * 
	 * Returns the view for editing a book. Adds book, found by passed
	 * id, as model attribute <code>question</code> and list of all categories
	 * as model attribute <code>categories</code>.
	 * 
	 * @param id of book to editing
	 * @param model
	 * @return name of the view for adding/editing a books
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String getEdit(@PathVariable Long id, Model model){
		model.addAttribute("book", bookService.findOne(id));
		model.addAttribute("categories", categoryService.findAll());
		return "addBookEdit";
		
	}
	
	
	/**
	 * Removes the book object with the specified id.
	 * @param id of book to remove
	 * @return the redirect view name, which redirects to book list
	 */
	@RequestMapping(value = "remove/{id}", method = RequestMethod.GET)
	public String remove(@PathVariable Long id){
		bookService.remove(id);
		return "redirect:..";
		
	}
	
	/**
	 *  Persists the passed book object
	 * @param book to persist 
	 * @param bd
	 * @param model
	 * @return the redirect view name, which redirects to book list
	 */
	@RequestMapping(params="save", method = RequestMethod.POST)
	public String post(@Valid Book book, BindingResult bd, Model model){
		String nameView;
		userValidator.validate(book, bd);
		if(!bd.hasErrors()){
			bookService.save(book);
			nameView = "redirect:books";
			
		} else {
			
			model.addAttribute("book", book);
			model.addAttribute("categories", categoryService.findAll());
			nameView = "addBookEdit";
		}
		return nameView;
		
	}
	/**
	 * Cancels the new/edit book action.
	 * 
	 * @return the redirect view name, which redirects to book list
	 */
	@RequestMapping(params = "cancel", method = RequestMethod.POST)
	public String cancel() {
		return "redirect:books";
	}
}
