/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.Student;
import bean.StudentMap;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import rest.Rest;

/**
 *
 * @author votha
 */
public class StudentDAO {

    ObjectMapper mapper = new ObjectMapper();

    public StudentMap findAll() {
        JsonNode resp = Rest.get("/students");
        return mapper.convertValue(resp, StudentMap.class);
    }

    public Student findByKey(String key) {
        JsonNode resp = Rest.get("/students/" + key);
        return mapper.convertValue(resp, Student.class);
    }

    public String create(Student data) {
        JsonNode resp = Rest.post("/students", data);
        return resp.get("name").asText();
    }

    public Student update(String key, Student data) {
        JsonNode resp = Rest.put("/students/" + key, data);
        return mapper.convertValue(resp, Student.class);
    }

    public void delete(String key) {
        Rest.delete("/students/" + key);
    }
}
