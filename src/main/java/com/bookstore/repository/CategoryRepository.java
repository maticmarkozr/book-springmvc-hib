package com.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.model.Category;

/**
 * Category JPA
 * 
 * @author Marcus
 *
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
