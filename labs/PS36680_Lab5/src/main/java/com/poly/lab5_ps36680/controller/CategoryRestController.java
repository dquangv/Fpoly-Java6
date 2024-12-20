package com.poly.lab5_ps36680.controller;

import java.util.List;

import com.poly.lab5_ps36680.dao.CategoryDAO;
import com.poly.lab5_ps36680.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin("*")
@RestController
public class CategoryRestController {
	@Autowired
	CategoryDAO cDao;

	@GetMapping("/rest/categories")
	public ResponseEntity<List<Category>> getAll(Model model) {
		return ResponseEntity.ok(cDao.findAll());
	}

	@GetMapping("/rest/categories/{id}")
	public ResponseEntity<Category> getOne(@PathVariable("id") String id) {
		if (!cDao.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(cDao.findById(id).get());
	}

	@PostMapping("/rest/categories")
	public ResponseEntity<Category> post(@RequestBody Category category) {
		if (cDao.existsById(category.getId())) {
			return ResponseEntity.badRequest().build();
		}
		cDao.save(category);
		return ResponseEntity.ok(category);
	}

	@PutMapping("/rest/categories/{id}")
	public ResponseEntity<Category> put(@PathVariable("id") String id, @RequestBody Category category) {
		if (cDao.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		cDao.save(category);
		return ResponseEntity.ok(category);
	}
	
	@DeleteMapping("/rest/categories/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") String id){
		if(!cDao.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		cDao.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
