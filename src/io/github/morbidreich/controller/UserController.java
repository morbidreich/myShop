package io.github.morbidreich.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.github.morbidreich.entity.User;
import io.github.morbidreich.service.UserService;
import io.github.morbidreich.utils.SortOptions;
import io.github.morbidreich.utils.UserSortOptions;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/userList")
	public String showUsers(
			Model model,
			@RequestParam(name="sortBy", required=false) String sortBy,
			@RequestParam(name="order", required=false) String order) {
		
		SortOptions sortOptions = new UserSortOptions(sortBy, order);
		
		List<User> users = userService.getUsers(sortOptions);
		
		
		model.addAttribute("users", users);
		return "user-list";
	}
	
	@RequestMapping("/addUserForm")
	public String addUser(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		
		return "user-form";
	}
	
	@PostMapping("/saveUser")
	public String saveCustomer(@ModelAttribute("user") User user) {
		
		userService.saveUser(user);
		return "redirect:/user/userList";
	}
	
	@RequestMapping("/deleteUser")
	public String deleteUser(@RequestParam(name="userId") int id) {
	
		userService.deleteUser(id);
		return "redirect:/user/userList";
	}
	
	@RequestMapping("/updateUserForm")
	public String updateUser(@RequestParam(name="userId") int id, Model model) {
		
		User user = userService.getUser(id);
		model.addAttribute("user", user);
		
		return "user-form";
	}
}
