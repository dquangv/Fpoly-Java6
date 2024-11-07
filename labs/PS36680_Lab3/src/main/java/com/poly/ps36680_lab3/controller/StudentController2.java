package com.poly.ps36680_lab3.controller;

import com.poly.ps36680_lab3.dao.StudentDAO;
import com.poly.ps36680_lab3.model.Student;
import com.poly.ps36680_lab3.model.StudentMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class StudentController2 {
	@Autowired
	StudentDAO dao;

	@RequestMapping("/student/index")
	public String index(Model model) {
		Student student = new Student("", "", 0.0, true, "VN");
		model.addAttribute("student", student);
		StudentMap map = dao.findAll();
		model.addAttribute("items", map);
		return "student/index";
	}

	@RequestMapping("/student/edit/{key}")
	public String edit(Model model, @PathVariable("key") String key) {
		model.addAttribute("key", key);
		Student student = dao.findByKey(key);
		model.addAttribute("student", student);
		StudentMap map = dao.findAll();
		model.addAttribute("items", map);
		return "student/index";
	}
	
	@RequestMapping("/student/create")
	public String create(Student student) {
		dao.create(student);
		return "redirect:/student/index";
	}
	
	@RequestMapping("/student/update/{key}")
	public String update(Student student, @PathVariable("key") String key) {
		dao.update(key, student);
		return "redirect:/student/edit/" + key;
	}
	
	@RequestMapping("/student/del/{key}")
	public String delete(@PathVariable("key") String key) {
		dao.delete(key);
		return "redirect:/student/index";
	}
}
