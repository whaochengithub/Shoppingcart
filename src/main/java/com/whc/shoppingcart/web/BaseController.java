package com.whc.shoppingcart.web;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.whc.shoppingcart.service.ProductService;
import com.whc.shoppingcart.service.UserService;

public class BaseController {
	protected ProductService ps;
	protected UserService us;
	public BaseController(){
		  
			@SuppressWarnings("resource")
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		 	this.ps = (ProductService)context.getBean("productManager");
		 	this.us = (UserService)context.getBean("userManager");
	}
	public void setPs(ProductService ps) {
		this.ps = ps;
	}

}
