package com.ronaldo.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ronaldo.shoppingbackend.dao.UserDAO;
import com.ronaldo.shoppingbackend.dto.Address;
import com.ronaldo.shoppingbackend.dto.Cart;
import com.ronaldo.shoppingbackend.dto.User;

public class UserTestCase {

	
	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user =null;
	private Address address =null;
	private Cart cart =null;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.ronaldo.shoppingbackend");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
//	@Test
//	public void testAdd(){
//		user = new User();
//		
//		user.setFirstNname("ronaldo");
//		user.setLastName("Martins");
//		user.setEmail("ronaldomartins06@gmail.com");
//		user.setContactNumber("0899633151");
//		user.setRole("USER");
//		user.setPassword("12345");
//		
//		assertEquals("Failed to add user", true, userDAO.addUser(user));
//		
//		address = new Address();
//		
//		address.setAddressLineOne("Apartment 00 Saint James Court");
//		address.setAddressLineTwo("James Street");
//		address.setCity("Dublin");
//		address.setState("Dublin");
//		address.setCountry("Ireland");
//		address.setPostalCode("D08DKD8");
//		address.setBilling(true);
//		address.setUserId(user.getId());
//		
//		assertEquals("Failed to add address", true, userDAO.addAddress(address));
//		
//		if( user.getRole().equals("USER") ){
//			cart = new Cart();
//			cart.setUser(user);
//			
//			address = new Address();
//			
//			assertEquals("Failed to add cart", true, userDAO.addCart(cart));
//			address.setAddressLineOne("00 Saint Declan's Road");
//			address.setAddressLineTwo("Marino");
//			address.setCity("Dublin");
//			address.setState("Dublin");
//			address.setCountry("Ireland");
//			address.setPostalCode("D03D06X");
//			address.setShipping(true);
//			address.setUserId(user.getId());
//			
//			assertEquals("Failed to add address", true, userDAO.addAddress(address));	
//		}
//		
//		
//	}
	
	@Test
	public void testAdd(){
		user = new User();
		
		user.setFirstName("ronaldo");
		user.setLastName("Martins");
		user.setEmail("ronaldomartins06@gmail.com");
		user.setContactNumber("0899633151");
		user.setRole("USER");
		user.setPassword("12345");
		

		if( user.getRole().equals("USER") ){
			cart = new Cart();
			cart.setUser(user);
			
			user.setCart(cart);
		}
		assertEquals("Failed to add user", true, userDAO.addUser(user));
	}
	
	@Test
	public void testUpdateCart(){
		user = userDAO.getByEmail("ronaldomartins06@gmail.com");
		System.out.println(user.getEmail());
		cart = user.getCart();
		
		cart.setGrandTotal(555);
		cart.setCartLines(2);
		
		assertEquals("Failed to update cart", true, userDAO.updateCart(cart));
	}
	
	@Test
	public void testAddAddress(){
		user = new User();
		
		user.setFirstName("ronaldo");
		user.setLastName("Martins");
		user.setEmail("ronaldomartins06@gmail.com");
		user.setContactNumber("0899633151");
		user.setRole("USER");
		user.setPassword("12345");
		
		assertEquals("Failed to add user", true, userDAO.addUser(user));
		
		address = new Address();
		
		address.setAddressLineOne("Apartment 00 Saint James Court");
		address.setAddressLineTwo("James Street");
		address.setCity("Dublin");
		address.setState("Dublin");
		address.setCountry("Ireland");
		address.setPostalCode("D08DKD8");
		address.setBilling(true);
		address.setUser(user);
		
		assertEquals("Failed to add address", true, userDAO.addAddress(address));
		
		address = new Address();
		
		address.setAddressLineOne("00 Saint Declan's Road");
		address.setAddressLineTwo("Marino");
		address.setCity("Dublin");
		address.setState("Dublin");
		address.setCountry("Ireland");
		address.setPostalCode("D03D06X");
		address.setShipping(true);
		address.setUser(user);
		
		assertEquals("Failed to add shipping address", true, userDAO.addAddress(address));	
	}
	
	@Test
	public void testAddAddress2(){
	
		user = userDAO.getByEmail("ronaldomartins06@gmail.com");
		
		address = new Address();
		
		address.setAddressLineOne("111 Brian Road");
		address.setAddressLineTwo("Marino");
		address.setCity("Dublin");
		address.setState("Dublin");
		address.setCountry("Ireland");
		address.setPostalCode("D03DDFF");
		address.setShipping(true);
		address.setUser(user);
		
		assertEquals("Failed to add shipping address", true, userDAO.addAddress(address));
	}
	
	@Test
	public void testGetAddress(){
		user = userDAO.getByEmail("ronaldomartins06@gmail.com");
		
		assertEquals("Failed to fetch shipping address",2, userDAO.listShippingAddress(user).size());
		
		assertEquals("Failed to fetch billing address","D08DKD8", userDAO.getBillingAddress(user).getPostalCode());
	}
	
}
