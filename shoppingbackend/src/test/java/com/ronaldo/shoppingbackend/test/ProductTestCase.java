package com.ronaldo.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ronaldo.shoppingbackend.dao.ProductDAO;
import com.ronaldo.shoppingbackend.dto.Product;
import com.ronaldo.shoppingbackend.dto.Product;

public class ProductTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private Product product;
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.ronaldo.shoppingbackend");
		context.refresh();
		
		productDAO = (ProductDAO)context.getBean("productDAO");
	}
	
	@Test
	public void testAddProduct()
	{
		product = new Product();
		
		product.setName("Oppo Selfie S43");
		product.setBrand("Oppo");
		product.setDescription("This is some description for Oppo mobile");
		product.setUnitPrice(780);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
		
		assertEquals("Successfully added a Product	inside the table", true, productDAO.add(product));
		
	}

	@Test
	public void testAcoesProduct()
	{
		product = new Product();
		product = productDAO.get(1);
		product.setQuantity(0);
		//product.setDescription("This is some description for Motorola mobile");
//		product.setName("Moto G");
//		product.setBrand("Motorola");
		
		assertEquals("Successfully updated a single product from the table", true, productDAO.update(product));
//		assertEquals("Successfully deleted a single product from the table", true, productDAO.delete(product));
//		assertEquals("Successfully fetched all the products", 6, productDAO.list().size());
	}
	
	@Test
	public void testListsProduct()
	{
		assertEquals("Successfully fetched all the products", 5, productDAO.listActiveProducts().size());
	}
	
}
