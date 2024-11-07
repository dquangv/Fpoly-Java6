package com.poly.ps36680_lab2.controller;

import java.io.File;
import java.io.IOException;

import com.poly.ps36680_lab2.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class HomeController {
	
	@RequestMapping("/home/index")
	public String index(Model model) throws StreamReadException, DatabindException, IOException {
		model.addAttribute("message", "Welcome to Thymeleaf");

		ObjectMapper mapper = new ObjectMapper();
		String path = "C:\\Users\\Quang\\OneDrive - FPT Polytechnic\\Desktop\\fpl\\hk6\\Java6\\official\\labs\\PS36680_Lab2\\src\\main\\resources\\static\\student.json";
		Student student = mapper.readValue(new File(path), Student.class);
		model.addAttribute("sv", student);

		return "home/index";
	}
}
