package com.bookstore.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.model.Book;
import com.bookstore.model.Category;
import com.bookstore.repository.BookRepository;
import com.bookstore.service.BookService;

/**
 * @author Marcus
 *
 */
@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookRepository bookRepository;

	

	/* (non-Javadoc)
	 * @see com.bookstore.service.CrudService#findOne(java.lang.Long)
	 */
	@Override
	public Book findOne(Long id) {
		
		return bookRepository.findOne(id);
	}

	/* (non-Javadoc)
	 * @see com.bookstore.service.CrudService#findAll()
	 */
	@Override
	public List<Book> findAll() {
		
		return bookRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.bookstore.service.CrudService#save(com.bookstore.model.AbstractBaseEntity)
	 */
	@Override
	@Transactional
	public Book save(Book book) {
		
		return bookRepository.save(book);
	}

	/* (non-Javadoc)
	 * @see com.bookstore.service.CrudService#remove(java.lang.Long)
	 */
	@Override
	public void remove(Long id) throws IllegalArgumentException {
		Book book = bookRepository.findOne(id);
		if(book == null){
			throw new IllegalArgumentException(String.format("Book with id=%d does not exist.", id));
		}
		bookRepository.delete(book);
	}

	/* (non-Javadoc)
	 * @see com.bookstore.service.BookService#findByCategory(com.bookstore.model.Category)
	 */
	@Override
	public List<Book> findByCategory(Category category) {
		
		return bookRepository.findByCategory(category);
	}

}
