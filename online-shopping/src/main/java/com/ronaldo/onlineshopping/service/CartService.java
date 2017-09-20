package com.ronaldo.onlineshopping.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ronaldo.onlineshopping.model.UserModel;
import com.ronaldo.shoppingbackend.dao.CartLineDAO;
import com.ronaldo.shoppingbackend.dto.Cart;
import com.ronaldo.shoppingbackend.dto.CartLine;

@Service("cartService")
public class CartService {

	@Autowired
	private CartLineDAO carLineDAO;
	
	@Autowired
	private HttpSession session;
	
	//returns the cart of the user
	private Cart getCart(){
		return ((UserModel)session.getAttribute("userModel")).getCart();
	}
	
	//returns the entire cart lines
	public List<CartLine> getCartLines(){
		return carLineDAO.list(this.getCart().getId());
	}
}
