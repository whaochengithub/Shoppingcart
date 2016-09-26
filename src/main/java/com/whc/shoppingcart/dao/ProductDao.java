package com.whc.shoppingcart.dao;

import java.util.List;

import org.hibernate.validator.internal.util.privilegedactions.GetAnnotationParameter;

import com.whc.common.dao.BaseDao;
import com.whc.shoppingcart.domain.Product;

public interface ProductDao extends BaseDao<Product>{
	//final int PAGE_SIZE = 3;
	
	public Product getProductbySku(String s);
	
	public List<Product> getProductByUser(String UserName);
	
	public List<Product> getAllProducts();
		
	
	
}
