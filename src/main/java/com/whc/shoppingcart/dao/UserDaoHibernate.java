package com.whc.shoppingcart.dao;

import java.util.List;

import com.whc.common.dao.BaseDaoHibernate4;
import com.whc.shoppingcart.domain.User;

public class UserDaoHibernate extends BaseDaoHibernate4<User> implements UserDao{

	@Override
	public List<User> findByNameAndPass(String UserName, char[] password) {
		return find("select u from User u where u.user_name = ?0 and u.user_password=?1"
				, UserName , password);
		}


	@Override
	public List<User> findByUserName(String username) {
		// TODO Auto-generated method stub
		return find("select u from User u where u.user_name = ?0"
				, username);
	}

}
