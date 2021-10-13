package io.github.morbidreich.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.morbidreich.dao.CategoryDAO;
import io.github.morbidreich.dao.ProductDAO;
import io.github.morbidreich.entity.Category;
import io.github.morbidreich.entity.Product;

@Service
public class SearchResultService {

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private ProductDAO productDAO;

	
	public List<Product> search(String categoryName, String searchPhrase) {

		if (categoryName.equals("Everywhere")) {
			List<Product> productList = productDAO.getProducts();
			
			return productList
					.stream()
					.filter(p -> p.getName().contains(searchPhrase))
					.collect(Collectors.toList());
			
		}	
		else {

			Category cat = categoryDAO.getCategories().stream().filter(c -> c.getName().equals(categoryName))
					.findFirst().get();

			return cat.getProductList().stream().filter(p -> p.getName().contains(searchPhrase))
					.collect(Collectors.toList());
		}

	}

}
