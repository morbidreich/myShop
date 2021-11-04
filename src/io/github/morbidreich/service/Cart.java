package io.github.morbidreich.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import io.github.morbidreich.entity.Product;

public class Cart {
	List<Product> products;

	public Cart() {
		products = new ArrayList<>();
	}

	public void addProduct(Product p) {
		products.add(p);
	}

	public List<Product> getProducts() {
		return products;
	}

	public double getTotalPrice() {
		return products.stream().mapToDouble(Product::getPrice).sum();
	}

	public void removeItem(int id) {
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getId() == id) {
				products.remove(i);
				return;
			}

		}
	}

	@Override
	public String toString() {
		return products.toString();
	}
}
