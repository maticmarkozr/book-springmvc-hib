package com.bookstore.web.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;


import com.bookstore.model.Category;
import com.bookstore.service.CategoryService;


public class StringToCategoryConverter implements Converter<String, Category>{
	
	@Autowired
	private CategoryService categoryService;

	@Override
	public Category convert(String catId) {
		
		return categoryService.findOne(Long.parseLong(catId));
	}

}
