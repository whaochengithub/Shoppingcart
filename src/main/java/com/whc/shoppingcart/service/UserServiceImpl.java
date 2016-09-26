package com.whc.shoppingcart.service;

import java.util.List;

import org.apache.tomcat.util.buf.UDecoder;

import com.whc.shoppingcart.dao.ProductDao;
import com.whc.shoppingcart.dao.UserDao;
import com.whc.shoppingcart.domain.Product;
import com.whc.shoppingcart.domain.User;
import com.whc.shoppingcart.exception.ShoppingCartException;

public class UserServiceImpl implements UserService{
	
	private UserDao ud;
	private ProductDao pd;
	
	public ProductDao getProductDao() {
		return pd;
	}

	public void setProductDao(ProductDao pd) {
		this.pd = pd;
	}

	public UserDao getUserDao() {
		return ud;
	}

	public void setUserDao(UserDao ud) {
		this.ud = ud;
	}

	@Override
	public void UserRegistration(User user) {
		String UserName = ud.get(User.class, user.getUserName()).getUserName();
		if(UserName==null){
		ud.save(user);
		}else{
			throw new ShoppingCartException("User already exist");
		}
	}

	@Override
	public List<Product> getProductsByUser(String username) {
		return pd.getProductByUser(username);
	}

	@Override
	public User UserValidation(String userName, char[] password) {
		
		List<User> list = ud.findByNameAndPass(userName, password);
		if(list!=null&&list.size()==1){
			return list.get(0);
		}
		return null;
	}

	@Override
	public int addNewProduct(Product p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Boolean checkUserExist(String userName) {
		if(ud.findByUserName(userName)!=null){
			return true;
		}
		return false;
	}

	@Override
	public void deleteProduct(Product pro) {
		
	}

}
