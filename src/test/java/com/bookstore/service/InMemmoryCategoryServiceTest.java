package com.bookstore.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.bookstore.model.Category;
import com.bookstore.service.memory.InMemmoryCategoryService;

public class InMemmoryCategoryServiceTest {
	
	private CategoryService catService;
	
	@Before
	public void setUp(){
		catService = new InMemmoryCategoryService();
		
		Category catHistory = new Category();
		catHistory.setId(1L);
		catHistory.setName("History");
		
		Category catRomance = new Category();
		catRomance.setId(2L);
		catRomance.setName("Romance");
		
		catService.save(catHistory);
		catService.save(catRomance);
	}
	
	@Test
	public void testFindOne(){
		Category cat1 = catService.findOne(1L);
		Assert.assertNotNull(cat1);
		Assert.assertEquals("History", cat1.getName());
	}
	
	@Test
	public void testFindAll(){
		//to do
	}
}
