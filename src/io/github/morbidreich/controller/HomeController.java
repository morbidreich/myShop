package io.github.morbidreich.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.morbidreich.dao.CategoryDAO;
import io.github.morbidreich.dao.ProductDAO;
import io.github.morbidreich.entity.Category;
import io.github.morbidreich.entity.Product;
import io.github.morbidreich.service.SearchResultService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	SearchResultService srs;
	
	String searchPhrase;
	
	
	@RequestMapping("/")
	public String getHomePage(Model model) {
		
		List<Product> productList = productDAO.getProducts();
		model.addAttribute("products", productList);	
		
		List<Category> categoryList = categoryDAO.getCategories();
		model.addAttribute("categories", categoryList);
		
		String testString = "Hello from HomeController!";
		model.addAttribute("greeting", testString);
		
		return "home-page";
	}
	
	@RequestMapping("searchProduct")
	public String searchProduct(HttpServletRequest req, Model model) {
		
		String searchPhrase = req.getParameter("searchPhrase");
		String selectedCategory = req.getParameter("category");
		
		List<Product> productsFound = srs.search(selectedCategory, searchPhrase);
		System.out.println("Search result item count: " + productsFound.size());
		
		model.addAttribute("productsFound", productsFound);
		model.addAttribute("searchPhrase", searchPhrase);
		model.addAttribute("selectedCategory", selectedCategory);
		
		return "search-result";
	}
	
	@RequestMapping("electronics")
	public String showElectronics() {
		return "electronics";
	}
	
	@RequestMapping("sport")
	public String showSport() {
		return "sport";
	}
	
	@RequestMapping("fashion")
	public String showFashion() {
		return "fashion";
	}
}
