package io.github.morbidreich.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.github.morbidreich.entity.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public Product getProduct(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Product.class, id);
	}
	
	@Override
	@Transactional
	public List<Product> getProducts() {
		//List<Product> out = new ArrayList<>();
		
		return sessionFactory.getCurrentSession().createQuery("from Product", Product.class).getResultList();
	}

}
