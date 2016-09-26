package com.whc.shoppingcart.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.whc.common.dao.BaseDaoHibernate4;
import com.whc.shoppingcart.domain.Product;

public class ProductDaoHibernate extends BaseDaoHibernate4<Product> implements ProductDao{

	@Override
	public Product getProductbySku(String sku) {
		//select p from Payment as p where p.employee=?0
		List<Product> products = find("select p from Product as p where p.sku=?0"
				, sku.toUpperCase());
			if (products != null && products.size() == 1)
			{
				return products.get(0);
			}
			return null;
	}

	@Override
	public List<Product> getProductByUser(String UserName) {
		List<Product> products = find("select p from Product as p where p.user_name=?0"
				, UserName);
			if (products != null && products.size() == 1)
			{
				return products;
			}
			return null;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getAllProducts() {
		List<Product> ProductList = new ArrayList<Product>();
		Session session = null;
		try{
			session = getSessionFactory().openSession();
			session.beginTransaction();
			String SQL_QUERY = "FROM Product";
			Query query = session.createQuery(SQL_QUERY);
			ProductList = (List<Product>)query.list();
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		
		
		return ProductList;
	}
	
}
