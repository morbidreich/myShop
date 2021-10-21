package io.github.morbidreich.entity;

import org.springframework.stereotype.Component;

@Component
public class ReviewWrapper {
	private String productId;
	private String rating;
	private String text;
	
	public ReviewWrapper() {}
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return "ReviewWrapper [productId=" + productId + ", rating=" + rating + ", text=" + text + "]";
	}
}
