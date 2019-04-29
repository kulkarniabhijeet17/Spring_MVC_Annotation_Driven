package com.abhijeet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.abhijeet.model.User;

@Controller
public class UserController {
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, HttpServletRequest request) {
		String username = request.getParameter("username");
		model.addAttribute("user", username);
		System.out.println(username);
		return "homePage";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("user", new User());

		return "registerUser";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, Model model) {
		// https://hellokoding.com/registration-and-login-example-with-spring-xml-configuration-maven-jsp-and-mysql/
		System.out.println("Registered username:: " + user.getUsername());
		// Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		// validator.validate(user, bindingResult);

		if (bindingResult.hasErrors()) {
			return "registerUser";
		}

		// userService.save(user);

		// securityService.autologin(user.getUsername(), user.getPassword());

		return "redirect:/welcome.springmvc";
	}

	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String welcome(Model model) {
		return "welcome";
	}
}