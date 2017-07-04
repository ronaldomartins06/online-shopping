package com.ronaldo.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * Created by Ronaldo Martins
 * */
import org.springframework.web.servlet.ModelAndView;

import com.ronaldo.shoppingbackend.dao.CategoryDAO;
import com.ronaldo.shoppingbackend.dto.Category;
@Controller
public class PageController {

	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value={"/", "/home", "/index"})
	public ModelAndView index()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		
		//list of category
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickHome", true);
		return mv;
	}
	
	@RequestMapping(value="/about")
	public ModelAndView about()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}
	
	@RequestMapping(value="/contact")
	public ModelAndView contact()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact");
		mv.addObject("userClickContact", true);
		return mv;
	}
	
	/*
	 * Methods to load all the products
	 * */
	@RequestMapping(value="/show/all/products")
	public ModelAndView showAllProducts()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		
		//list of category
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickAllProducts", true);
		return mv;
	}
	
	@RequestMapping(value="/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id)
	{
		ModelAndView mv = new ModelAndView("page");
		
		//categoryDAO to get a single category
		Category category = null;
		category = categoryDAO.get(id);
		mv.addObject("title", category.getName());
		
		//list of category
		mv.addObject("categories", categoryDAO.list());
		
		//passing a single category object
		mv.addObject("category", category);
		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}

}
