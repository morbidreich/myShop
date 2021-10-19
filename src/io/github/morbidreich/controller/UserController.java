package io.github.morbidreich.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.morbidreich.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/userList")
	public String showUsers(Model model) {
		model.addAttribute("users", userService.getUsers());
		return "user-list";
	}
}
