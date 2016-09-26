package com.whc.shoppingcart.service;

import java.util.List;

import com.whc.shoppingcart.domain.Product;
import com.whc.shoppingcart.domain.User;

public interface UserService {
	public void UserRegistration(User user);
	public List<Product> getProductsByUser(String UserName);
	public User UserValidation(String userName, char[] password);
	public int addNewProduct(Product p);
	public Boolean checkUserExist(String userName);
	public void deleteProduct(Product pro);
}
