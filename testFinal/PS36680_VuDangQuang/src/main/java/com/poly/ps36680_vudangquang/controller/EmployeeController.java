package com.poly.ps36680_vudangquang.controller;

import com.poly.ps36680_vudangquang.dao.EmployeeDAO;
import com.poly.ps36680_vudangquang.entity.Employee;
import com.poly.ps36680_vudangquang.entity.EmployeeMap;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeDAO dao;


	// Chuẩn bị danh sách ngành
	@ModelAttribute("majors")
	public List<String> getMajors() {
		return List.of("Công nghệ thông tin", "Kỹ thuật phần mềm", "Hệ thống thông tin",
				"Trí tuệ nhân tạo", "An ninh mạng");
	}
	@RequestMapping("/student/index")
	public String index(Model model) {
		Employee student = new Employee();
		model.addAttribute("student", student);
		EmployeeMap map = dao.findAll();
		model.addAttribute("items", map);
		return "student/index";
	}

	@RequestMapping("/student/edit/{key}")
	public String edit(Model model, @PathVariable("key") String key) {
		model.addAttribute("key", key);
		Employee student = dao.findByKey(key);
		model.addAttribute("student", student);
		EmployeeMap map = dao.findAll();
		model.addAttribute("items", map);
		return "student/index";
	}
	@RequestMapping("/student/create")
	public String create(@Valid @ModelAttribute("student") Employee student,
						 BindingResult result, Model model) {
		if (result.hasErrors()) {
			// Nếu có lỗi, thêm các attribute vào model
			EmployeeMap map = dao.findAll();
			model.addAttribute("items", map); // Danh sách sinh viên
			return "student/index";
		}

		if (dao.findByMaSV(student.getMaNV())) {
			// Thêm lỗi tùy chỉnh
			result.rejectValue("maNV", "error.student", "Mã sinh viên đã tồn tại");
			EmployeeMap map = dao.findAll();
			model.addAttribute("items", map);
			return "student/index";
		}

		dao.create(student); // Thêm sinh viên mới
		return "redirect:/student/index";
	}

	@RequestMapping("/student/update/{key}")
	public String update(@Valid @ModelAttribute("student") Employee student,
						 BindingResult result, @PathVariable("key") String key,
						 Model model) {
		if (result.hasErrors()) {
			EmployeeMap map = dao.findAll();
			model.addAttribute("items", map); // Danh sách sinh viên
			model.addAttribute("key", key); // Key để sửa
			return "student/index";
		}

		dao.update(key, student); // Cập nhật sinh viên
		return "redirect:/student/index";
	}

	@RequestMapping("/student/del/{key}")
	public String delete(@PathVariable("key") String key) {
		dao.delete(key);
		return "redirect:/student/index";
	}
}
