package com.poly.ps36680_lab4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/home/index")
	public String home(Model model) {
		return "home/index";
	}
	
	@GetMapping("/home/about")
	public String about(Model model) {
		return "home/about";
	}
}
