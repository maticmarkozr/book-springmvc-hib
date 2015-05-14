package com.bookstore.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.model.Book;
import com.bookstore.model.Category;
import com.bookstore.repository.BookRepository;
import com.bookstore.repository.CategoryRepository;
import com.bookstore.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private BookRepository bookRepository;

	/* (non-Javadoc)
	 * @see com.bookstore.service.CrudService#findOne(java.lang.Long)
	 */
	@Override
	public Category findOne(Long id) {
		
		return categoryRepository.findOne(id);
	}

	/* (non-Javadoc)
	 * @see com.bookstore.service.CrudService#findAll()
	 */
	@Override
	public List<Category> findAll() {
		
		return categoryRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.bookstore.service.CrudService#save(com.bookstore.model.AbstractBaseEntity)
	 */
	@Override
	@Transactional
	public Category save(Category category) {
		
		return categoryRepository.save(category);
	}

	/* (non-Javadoc)
	 * @see com.bookstore.service.CrudService#remove(java.lang.Long)
	 */
	@Override
	@Transactional
	public void remove(Long id) throws IllegalArgumentException {
		Category category = categoryRepository.findOne(id);
		if(category == null){
			throw new IllegalArgumentException(String.format("Category with id=%d does not exist.", id));
		}
		
	// Find all the books in this category and set the category to null
	// ("Uncategorized")
		List<Book> books = bookRepository.findByCategory(category);
		
		for (Book book : books) {
			book.setCategory(null);
			bookRepository.save(book);
		}
		
		categoryRepository.delete(id);
		
	}


}
