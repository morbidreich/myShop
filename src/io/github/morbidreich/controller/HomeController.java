package io.github.morbidreich.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	// moves user to search result page
	@RequestMapping("searchProduct") 
	public String searchProduct(
			// access parameters defined in html with "name=" attribute
			// i previously did that with HttpServletResponse resp, and then
			// resp.getParameter("name")
			@RequestParam("searchPhrase") String searchPhrase,
			@RequestParam("category") String category,
			Model model) {
		
		List<Product> productsFound = srs.search(category, searchPhrase);
		
		model.addAttribute("productsFound", productsFound);
		model.addAttribute("searchPhrase", searchPhrase);
		model.addAttribute("category", category);
		
		model.addAttribute("greeting", "Welcome dear Customer!");
		
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
	
	// temporary method to display product page - will load one product and
	// display its page with this method
	// TODO revert to previous logic
	@RequestMapping("manage")
	public String manageProduct(Model model) {
		
		Product product = productDAO.getProduct(1);
		model.addAttribute("product", product);
		
		return "product-page";
	}
}
