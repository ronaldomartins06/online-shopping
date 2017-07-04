package com.ronaldo.shoppingbackend.dao;

import java.util.List;

import com.ronaldo.shoppingbackend.dto.Category;

public interface CategoryDAO {

	public List<Category> list();
	public Category get(int id);	
}
