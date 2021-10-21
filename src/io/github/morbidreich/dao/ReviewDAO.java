package io.github.morbidreich.dao;

import io.github.morbidreich.entity.Review;

public interface ReviewDAO {
	public void saveReview(Review review);
	public double getAverageRatingForProduct(int productId);
}
