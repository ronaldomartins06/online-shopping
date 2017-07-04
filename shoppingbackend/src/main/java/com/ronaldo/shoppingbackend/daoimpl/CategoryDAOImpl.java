package com.ronaldo.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ronaldo.shoppingbackend.dao.CategoryDAO;
import com.ronaldo.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();
	
	static {
		//first category
		Category category = new Category();
		category.setId(1);
		category.setName("Televison");
		category.setDescription("New Television");
		category.setImageURL("CAT_1.png");
		
		categories.add(category);
		
		//second category
		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("Sumsung");
		category.setImageURL("CAT_2.png");
		
		categories.add(category);
		
		//third category
		category = new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("New brands");
		category.setImageURL("CAT_3.png");
		
		categories.add(category);
	}
	
	@Override
	public List<Category> list() {
		//returning a list of categories
		return categories;
	}

	@Override
	public Category get(int id) {
		// 
		for(Category category : categories){
			if(category.getId() == id) return category;
		}
		
		return null;
	}

}
