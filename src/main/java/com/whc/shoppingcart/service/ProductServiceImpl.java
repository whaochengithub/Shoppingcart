package com.whc.shoppingcart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.whc.shoppingcart.dao.ProductDao;
import com.whc.shoppingcart.domain.Product;


@Service
public class ProductServiceImpl implements ProductService{
	
	private ProductDao  pd;
	
	public void setProductDao(ProductDao pd){
		this.pd = pd;
	}
	

	public List<Product> getStoreProducts() {	
		return pd.getAllProducts();
	}

	public int addProduct(String name, String description, float price, int cal) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteProduct(List<Product> products) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public Product getProductBySku(String sku) {
		// TODO Auto-generated method stub
		return pd.getProductbySku(sku);
	}

}
