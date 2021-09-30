package io.github.morbidreich.dao;

import java.util.List;

import io.github.morbidreich.entity.Product;



public interface ProductDAO {
	
	public Product getProduct();
	public List<Product> getProducts();

}
