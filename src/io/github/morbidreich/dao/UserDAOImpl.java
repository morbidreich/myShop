package io.github.morbidreich.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.github.morbidreich.entity.User;
import io.github.morbidreich.utils.SortOptions;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public User getUser(int id) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.get(User.class, id);
		return user;
	}

	@Override
	@Transactional
	public List<User> getUsers(SortOptions sortOptions) {

		Session session = sessionFactory.getCurrentSession();
		Query<User> query;
		List<User> users;

		String sortByStr = sortOptions.getSortBy();
		String orderStr = sortOptions.getOrder();

		query = session.createQuery("from User order by " + sortByStr + " " + orderStr, User.class);
		users = query.getResultList();
		return users;
	}

	@Override
	@Transactional
	public void saveUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
	}

	@Override
	@Transactional
	public void deleteUser(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from User where id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

}
