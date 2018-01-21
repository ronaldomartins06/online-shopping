package com.ronaldo.shoppingbackend.dao;

import java.util.List;

import com.ronaldo.shoppingbackend.dto.Cart;
import com.ronaldo.shoppingbackend.dto.CartLine;

public interface CartLineDAO {

	public List<CartLine> list(int cartId);
	public CartLine get(int id);	
	public boolean add(CartLine cartLine);
	public boolean update(CartLine cartLine);
	public boolean delete(CartLine cartLine);
	public boolean updateCart(Cart cart);
	public List<CartLine> listAvailable(int cartId);
	public CartLine getByCartAndProduct(int cartId, int productId);
}
