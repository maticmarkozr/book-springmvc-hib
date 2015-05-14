package com.bookstore.service;

import java.util.List;



import com.bookstore.model.Book;
import com.bookstore.model.Category;

/**
 * @author Marcus
 *
 */
public interface BookService extends CrudService<Book>{
	
	/**
	 * Return all books within the same category.
	 * @param categoryId
	 * @return list of books associated with category
	 */
	List<Book> findByCategory(Category category);
}
