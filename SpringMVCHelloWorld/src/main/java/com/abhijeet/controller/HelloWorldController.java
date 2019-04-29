package com.abhijeet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
	@RequestMapping(value = "/hello")
	public String sayWelcome(Model model) {
		return "hello";
	}
}