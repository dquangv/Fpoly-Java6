package com.poly.ps36680_vudangquang.dao;

import com.fasterxml.jackson.databind.JsonNode;
import com.poly.ps36680_vudangquang.entity.Employee;
import com.poly.ps36680_vudangquang.entity.EmployeeMap;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class EmployeeDAO {
	RestTemplate rest = new RestTemplate();
	String url = "https://ps36680-vudangquang-default-rtdb.firebaseio.com/employees.json";
	
	private String getURL(String key) {
		return url.replace(".json", "/" + key + ".json");
	}
	
	public EmployeeMap findAll() {
		return rest.getForObject(url, EmployeeMap.class);
	}
	
	public Employee findByKey(String key) {
		return rest.getForObject(getURL(key), Employee.class);
	}

	public boolean checkKey(String km) {
		return rest.getForObject(getURL(km), Employee.class) != null;
	}

	public String create(Employee data) {
		HttpEntity<Employee> entity = new HttpEntity<Employee>(data);
		JsonNode resp = rest.postForObject(url, entity, JsonNode.class);
		return resp.get("name").asText();
	}
	
	public Employee update(String key, Employee data) {
		HttpEntity<Employee> entity = new HttpEntity<Employee>(data);
		rest.put(getURL(key), entity);
		return data;
	}
	
	public void delete(String key) {
		rest.delete(getURL(key));
	}

	public boolean findByMaSV(String maNV) {
		EmployeeMap map = findAll();
		if (map == null) return false;

		return map.values().stream()
				.anyMatch(student -> student.getMaNV().equals(maNV));
	}
}
