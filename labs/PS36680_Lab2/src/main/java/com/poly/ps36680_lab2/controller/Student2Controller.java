package com.poly.ps36680_lab2.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.poly.ps36680_lab2.model.Student;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class Student2Controller {
	@RequestMapping("/student/list")
	public String list(Model model, @RequestParam("index") Optional<Integer> index) throws IOException {
		File file = new ClassPathResource("/static/students.json").getFile();
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<Student>> typeReference = new TypeReference<>() {};
		List<Student> list = mapper.readValue(file, typeReference);
		model.addAttribute("dssv", list);
		model.addAttribute("sv", list.get(index.orElse(0)));
		return "student/list";
	}
}
