package com.whc.shoppingcart.service;

import java.util.List;

import com.whc.shoppingcart.domain.Product;

public interface ProductService {
	public List<Product> getStoreProducts();
	public Product getProductBySku(String sku);
	public int addProduct(String name , String description  , float price, int cal);
	public int deleteProduct(List<Product> products);
}
