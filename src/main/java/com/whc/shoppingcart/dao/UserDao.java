package com.whc.shoppingcart.dao;

import java.util.List;


import com.whc.common.dao.BaseDao;
import com.whc.shoppingcart.domain.User;

public interface UserDao extends BaseDao<User>{
	
	public List<User> findByNameAndPass(String UserName, char[] password);
	
	
	
	public List<User> findByUserName(String name);
}
