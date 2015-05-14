package com.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.model.Book;
import com.bookstore.model.Category;

/**
 * Book JPA
 * 
 * @author Marcus
 *
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
	
	/**
	 * Find and return book by cat id
	 * @param id cat id
	 * @return list of books from category
	 */
	List<Book> findByCategory(Category category);

}
