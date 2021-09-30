package io.github.morbidreich.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.github.morbidreich.entity.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Category> getCategories() {		
		Session session = sessionFactory.getCurrentSession();
		List<Category> out = session.createQuery("from Category", Category.class).getResultList();
		return out;
	}

}
