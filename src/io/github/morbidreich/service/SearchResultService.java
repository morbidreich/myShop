package io.github.morbidreich.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.morbidreich.dao.CategoryDAO;
import io.github.morbidreich.entity.Category;
import io.github.morbidreich.entity.Product;

@Service
public class SearchResultService {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	public Product search(String categoryName, String searchPhrase) {
		
		Category cat = categoryDAO.getCategories()
					.stream()
					.filter(c -> c.getName().equals(categoryName))
					.findFirst().get();
		
		return cat.getProductList()
					.stream()
					.filter(p -> p.getName().contains(searchPhrase))
					.findFirst().get();
		
		
	}
	

}
