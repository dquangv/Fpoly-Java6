package com.poly.ps36680_lab2.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.poly.ps36680_lab2.model.Student2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class StudentController {
	@RequestMapping("/student")
	public String index(Model model, @RequestParam("index") Optional<Integer> index)
			throws StreamReadException, DatabindException, IOException {
		// Doc danh sach du lieu tu file
		ObjectMapper mapper = new ObjectMapper();
		File pathFile = ResourceUtils.getFile("classpath:static/listStudent.json");
		TypeReference<List<Student2>> typeReference = new TypeReference<List<Student2>>() {};
		List<Student2> student2 = mapper.readValue(pathFile, typeReference);

		int i = index.orElse(0);
		model.addAttribute("n", i);
		model.addAttribute("sv", student2.get(i));
		model.addAttribute("total", student2.size());
		return "scope/student";
	}
}
