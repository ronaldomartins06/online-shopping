package com.ronaldo.shoppingbackend.dao;

import java.util.List;

import com.ronaldo.shoppingbackend.dto.Address;
import com.ronaldo.shoppingbackend.dto.Cart;
import com.ronaldo.shoppingbackend.dto.User;

public interface UserDAO {

	public boolean addUser(User user);
	public boolean addAddress(Address address);
	public boolean updateCart(Cart cart);
	public User getByEmail(String email);
	public Address getBillingAddress(User user);
	public List<Address> listShippingAddress(User user);
}
	