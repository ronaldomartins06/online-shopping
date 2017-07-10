package com.ronaldo.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ronaldo.shoppingbackend.dao.CategoryDAO;
import com.ronaldo.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category category;
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.ronaldo.shoppingbackend");
		context.refresh();
		
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	}
	
	@Test
	public void testAddCategory()
	{
		category = new Category();
		
		category.setName("TV");
		category.setDescription("Samsung Television");
		category.setImageURL("CAT_4.png");
		
		assertEquals("Successfully added a category	inside the table", true, categoryDAO.add(category));
	}
	
	@Test
	public void testGetCategory()
	{
		category = categoryDAO.get(1);
		
		assertEquals("Successfully fetched a single category from the table", "Televison", category.getName());
	}
	
	@Test
	public void testUpdateCategory()
	{
		category = categoryDAO.get(1);
		category.setName("TV");
		assertEquals("Successfully updated a single category from the table", true, categoryDAO.update(category));
	}
	
	@Test
	public void testDeleteCategory()
	{
		category = categoryDAO.get(2);
		assertEquals("Successfully deleted a single category from the table", true, categoryDAO.delete(category));
	}
	
	@Test
	public void testListCategory()
	{
		assertEquals("Successfully fetched a list of category from the table", 3, categoryDAO.list().size());
	}
}
