package com.whc.shoppingcart.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.WebApplicationContextUtils;


import com.whc.shoppingcart.domain.Product;
import com.whc.shoppingcart.service.ProductService;

@Controller

public class StoreController extends BaseController{
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String printHello() {
	      //System.out.println("!!!!!!!!!!!!!!get index!!!!!!!!!!!!!!!!!");
	      return "index";
	   }


	@RequestMapping(value="/products", method = RequestMethod.GET)
	public @ResponseBody  List<Product> getAllProduct(){
		List<Product> products = ps.getStoreProducts();
		//System.out.println("!!!!!!!!!!!!!!retrun list from sever!!!!!!!!!!!!!!!!!");
		return products;
	}
	
	
	@RequestMapping(value = "/productBySku", params = {"sku"} ,  method = RequestMethod.GET)
	public @ResponseBody Product ProductDetails(@RequestParam(value = "sku") String sku){
		Product p = ps.getProductBySku(sku);
		return p;
	}
	
}
