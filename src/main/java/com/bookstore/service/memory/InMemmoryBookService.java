package com.bookstore.service.memory;

import java.util.ArrayList;
import java.util.List;





import org.springframework.stereotype.Service;

import com.bookstore.model.Book;
import com.bookstore.model.Category;
import com.bookstore.service.BookService;

@Service
public class InMemmoryBookService extends AbstractInMemmoryService<Book> implements BookService{

	@Override
	public List<Book> findByCategory(Category category) {
		List<Book> result = new ArrayList<>();
		for (Book b : findAll()) {
			if (b.getCategory() != null && b.getCategory().getId().equals(category)) {
				result.add(b);
			}
		}
		return result;
	}

}
