package com.ronaldo.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * Created by Ronaldo Martins
 * */
import org.springframework.web.servlet.ModelAndView;
@Controller
public class PageController {

	@RequestMapping(value={"/", "/home", "/index"})
	public ModelAndView index()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", "Welcome to Spring Web MVC");
		return mv;
	}
}
