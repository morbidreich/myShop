package io.github.morbidreich.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.github.morbidreich.entity.Review;

@Repository
public class ReviewDAOImpl implements ReviewDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void saveReview(Review review) {
		Session session = sessionFactory.getCurrentSession();
		session.save(review);
	}

	@Override
	@Transactional
	public double getAverageRatingForProduct(int productId) {
		Session session = sessionFactory.getCurrentSession();

		
		Query<Review> query = session.createQuery("from Review where product.id=" + productId, Review.class);
		
		
		List<Review> reviewList = query.getResultList();

		double average = -1;

		if (reviewList.size() > 0) {
			average = reviewList.stream().mapToDouble(Review::getRating).average().getAsDouble();
		}

		return average;
	}
}
