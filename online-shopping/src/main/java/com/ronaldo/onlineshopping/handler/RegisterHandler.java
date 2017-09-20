package com.ronaldo.onlineshopping.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.ronaldo.onlineshopping.model.RegisterModel;
import com.ronaldo.shoppingbackend.dao.UserDAO;
import com.ronaldo.shoppingbackend.dto.Address;
import com.ronaldo.shoppingbackend.dto.Cart;
import com.ronaldo.shoppingbackend.dto.User;

@Component
public class RegisterHandler {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public RegisterModel init(){
		
		return new RegisterModel();
	}
	
	public void addUser(RegisterModel registerModel, User user){
		registerModel.setUser(user);
	}
	
	public void addBilling(RegisterModel registerModel, Address billing){
		registerModel.setBilling(billing);
	}
	
	public String saveAll(RegisterModel model){
		String transitionValue = "success";
		
		User user = model.getUser();
		
		if(user.getRole().equals("USER")){
			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
		}
		
		//encoding the password
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userDAO.addUser(user);
		
		//get the address
		Address billing = model.getBilling();
		billing.setUser(user);
		billing.setBilling(true);
		
		userDAO.addAddress(billing);
		
		return transitionValue;
	}
	
	public String validateUser(User user, MessageContext error){
		
		String transitionValue = "success";
		
		if(!(user.getPassword().equals(user.getConfirmPassword()))){
				error.addMessage(new MessageBuilder()
					.error()
					.source("confirmPassword")
					.defaultText("Confirm Password does not match with password!")
					.build()
					);
			transitionValue = "failure";
		}
		
		if(userDAO.getByEmail(user.getEmail()) != null){
			error.addMessage(new MessageBuilder()
					.error()
					.source("email")
					.defaultText("Email address is already userd!")
					.build()
					);
			transitionValue = "failure";
		}
		return transitionValue;
	}
	
}
