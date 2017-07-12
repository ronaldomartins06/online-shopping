package com.ronaldo.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ronaldo.shoppingbackend.dao.CategoryDAO;
import com.ronaldo.shoppingbackend.dto.Category;
import com.ronaldo.shoppingbackend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	
	@Autowired
	CategoryDAO categoryDAO;

	@RequestMapping(value="/products", method=RequestMethod.GET)
	public ModelAndView showManageProducts()
	{
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");
		
		Product nProduct  = new Product();
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		
		mv.addObject("product", nProduct);
		
		return mv; 
	}
	
	@ModelAttribute("categories")
	public List<Category> getCategories()
	{
		return categoryDAO.list();
	}
}
