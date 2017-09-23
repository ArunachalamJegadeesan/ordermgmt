package com.caveofprogramming.spring.web.controller;

import com.caveofprogramming.spring.web.model.User;
import com.caveofprogramming.spring.web.service.SecurityService;
import com.caveofprogramming.spring.web.service.UserService;
import com.caveofprogramming.spring.web.validator.UserValidator;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserValidator userValidator;
	
	Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = "/newaccount", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("userForm", new User());

		return "newaccount";
	}

	@RequestMapping(value = "/newaccount", method = RequestMethod.POST)
	public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
		logger.debug("inside new account>>>>");

		userValidator.validate(userForm, bindingResult);
		logger.debug("Inside registration>>>>");
		if (bindingResult.hasErrors()) {
			return "newaccount";
		}

		userForm.setEnabled(true);

		logger.debug("before save registration>>>>");
		userService.save(userForm);
		logger.debug("after save registration>>>>");

		securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());
		logger.debug("last  registration>>>>");

		return "redirect:/accountcreated";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		logger.debug("Inside login>>>>>");
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "login";
	}

	@RequestMapping(value = "/accountcreated", method = RequestMethod.GET)
	public String accountCreated(Model model) {
		logger.debug("Inside accountcreated>>>>>");
		return "accountcreated";

	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(Model model) {
		logger.debug("Inside welcome>>>>>");
		// return "accountcreated";
		return "home";
	}

	@RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
	public String exit(Model model) {
		logger.debug("Inside logout>>>>>");
		return "login";

	}

	@RequestMapping("/admin")
	public String showAdmin(Model model) {

		List<User> users = userService.getAllUsers();

		model.addAttribute("users", users);

		return "admin";
	}

}
