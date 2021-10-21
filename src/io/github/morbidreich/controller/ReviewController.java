package io.github.morbidreich.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.morbidreich.dao.ProductDAO;
import io.github.morbidreich.dao.ReviewDAO;
import io.github.morbidreich.entity.Review;
import io.github.morbidreich.entity.ReviewWrapper;

@Controller
@RequestMapping("/review")
public class ReviewController {
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	ReviewDAO reviewDAO;
	
	@PostMapping("/saveReview")
	public String saveReview(
			@ModelAttribute("reviewWrapper") ReviewWrapper rw) {
		
		System.out.println(rw);
		
		Review r = new Review();
		
		r.setText(rw.getText());
		r.setRating(Integer.parseInt(rw.getRating()));
		r.setProduct(productDAO.getProduct(Integer.parseInt(rw.getProductId())));
		
		reviewDAO.saveReview(r);
		
		return "redirect:/productPage?productId=" + rw.getProductId();
	}

}
