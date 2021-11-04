package io.github.morbidreich.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.github.morbidreich.dao.ProductDAO;
import io.github.morbidreich.entity.Product;
import io.github.morbidreich.service.Cart;

@Controller
@RequestMapping("/")
public class CartController {

	@Autowired
	ProductDAO productDAO;

	@PostMapping("/cartResolution")
	public String processCart(@RequestParam("productId") int productId, Model model, HttpServletRequest req) {

		Product p = productDAO.getProduct(productId);
		System.out.println("got from database: " + p);

		HttpSession session = req.getSession();
		System.out.println("got HttpSession object");

		Cart cart = (Cart) session.getAttribute("cart");
		System.out.println("Got cart object from session: " + cart);

		if (cart == null) {
			cart = new Cart();
			cart.addProduct(p);
			System.out.println("cart is null, creating instance..");
		} else {
			cart.addProduct(p);
			System.out.println("added product to cart");
		}
		
		model.addAttribute("product", p);
		model.addAttribute("productsInCart", cart.getProducts().size());
		model.addAttribute("cart", cart);
		
		session.setAttribute("cart", cart);

		return "addedToCart";
	}
	
	@GetMapping("/cart")
	public String showCart(HttpServletRequest req, Model model) { 
		
		HttpSession session = req.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		
		if (cart == null)
			cart = new Cart();
		
		model.addAttribute("itemsNo", cart.getProducts().size());
		model.addAttribute("items", cart.getProducts());
		
		return "cart";
	}
	
	@GetMapping("/cart/remove")
	public String removeProductFromCart(@RequestParam("id") int id, HttpSession session) {
		
		Cart cart = (Cart) session.getAttribute("cart");
		System.out.println(cart);
		
		if (cart != null) 
			cart.removeItem(id);
		
		session.setAttribute("cart", cart);
		
		return "redirect:/cart";
	}
}
