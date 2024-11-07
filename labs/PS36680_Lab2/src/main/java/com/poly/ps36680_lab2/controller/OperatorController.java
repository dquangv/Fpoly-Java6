package com.poly.ps36680_lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OperatorController {
	@RequestMapping("/operator")
	public String demo(Model model) {
		model.addAttribute("x", 5);
		model.addAttribute("y", 7);
		return "operator";
	}
}
