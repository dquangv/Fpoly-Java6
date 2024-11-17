package com.poly.ps36680_lab4.dao;

import com.poly.ps36680_lab4.model.Student;
import com.poly.ps36680_lab4.model.StudentMap;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;


@Repository
public class StudentDAO {
	RestTemplate rest = new RestTemplate();
	String url = "https://java-6-ps36680-default-rtdb.firebaseio.com/students.json";
	
	private String getURL(String key) {
		return url.replace(".json", "/" + key + ".json");
	}
	
	public StudentMap findAll() {
		return rest.getForObject(url, StudentMap.class);
	}
	
	public Student findByKey(String key) {
		return rest.getForObject(getURL(key), Student.class);
	}
	
	public String create(Student data) {
		HttpEntity<Student> entity = new HttpEntity<Student>(data);
		JsonNode resp = rest.postForObject(url, entity, JsonNode.class);
		return resp.get("name").asText();
	}
	
	public Student update(String key, Student data) {
		HttpEntity<Student> entity = new HttpEntity<Student>(data);
		rest.put(getURL(key), entity);
		return data;
	}
	
	public void delete(String key) {
		rest.delete(getURL(key));
	}
}
