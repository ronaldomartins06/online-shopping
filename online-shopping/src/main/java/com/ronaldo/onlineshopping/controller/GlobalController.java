package com.ronaldo.onlineshopping.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ronaldo.onlineshopping.model.UserModel;
import com.ronaldo.shoppingbackend.dao.UserDAO;
import com.ronaldo.shoppingbackend.dto.User;

@ControllerAdvice
public class GlobalController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserDAO userDAO;
	
	private UserModel userModel = null;
	
	@ModelAttribute("userModel")
	public UserModel getUserModel(){
		
		if( session.getAttribute("userModel") == null ){
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			
			User user = userDAO.getByEmail(authentication.getName());
			if( user != null ){
				userModel = new UserModel();
				//creating a new UserModel object to pass the user details
				userModel.setId(user.getId());
				userModel.setEmail(user.getEmail());
				userModel.setRole(user.getRole());
				userModel.setFullName(user.getFirstName() +" "+ user.getLastName());
				
				if( userModel.getRole().equals("USER") ){
					//if the user is a customer set the cart
					userModel.setCart(user.getCart());
				}
					
				//setting the userModel in the session
				session.setAttribute("userModel", userModel);
				
				return userModel;
			}
		}
		
		return (UserModel) session.getAttribute("userModel");
	}
}
