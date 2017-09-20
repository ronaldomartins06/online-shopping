package com.ronaldo.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ronaldo.shoppingbackend.dao.CartLineDAO;
import com.ronaldo.shoppingbackend.dao.ProductDAO;
import com.ronaldo.shoppingbackend.dao.UserDAO;
import com.ronaldo.shoppingbackend.dto.Cart;
import com.ronaldo.shoppingbackend.dto.CartLine;
import com.ronaldo.shoppingbackend.dto.Product;
import com.ronaldo.shoppingbackend.dto.User;

public class CartLineTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CartLineDAO 	cartLineDAO = null;
	private static UserDAO 		userDAO		= null;
	private static ProductDAO 	productDAO 	= null;
	
	private User user			= null;
	private CartLine cartLine 	= null;	
	private Cart cart 			= null;
	private Product product 	= null;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.ronaldo.shoppingbackend");
		context.refresh();
		
		productDAO 	= (ProductDAO) context.getBean("productDAO");
		cartLineDAO = (CartLineDAO) context.getBean("cartLineDAO");
		userDAO 	= (UserDAO) context.getBean("userDAO");
	}
	
	@Test
	public void testAddNewCartLine(){
		user = userDAO.getByEmail("gabriela@gmail.com");
		
		cart = user.getCart();
		product = productDAO.get(3);
		
		cartLine = new CartLine();
		cartLine.setBuyingPrice(product.getUnitPrice());
		cartLine.setProductCount(cartLine.getProductCount() + 1);
		cartLine.setTotal(cartLine.getProductCount() * product.getUnitPrice());
		
		cartLine.setCartId(cart.getId());
		cartLine.setProduct(product);
		
		assertEquals("Failed to add the cartLine", true, cartLineDAO.add(cartLine));
		
		cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
		cart.setCartLines(cart.getCartLines() + 1);
		
		assertEquals("Failed to update the cart", true, cartLineDAO.updateCart(cart));
	}
	
	
	@Test
	public void testUpdateCart(){
		user = userDAO.getByEmail("ronaldomartins06@gmail.com");
		System.out.println(user.getEmail());
		cart = user.getCart();
		
		cart.setGrandTotal(555);
		cart.setCartLines(2);
		
		assertEquals("Failed to update cart", true, cartLineDAO.updateCart(cart));
	}

}
