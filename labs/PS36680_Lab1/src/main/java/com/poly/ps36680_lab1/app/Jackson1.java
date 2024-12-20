package com.poly.ps36680_lab1.app;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Jackson1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Demo 1");
		demo1();
		System.out.println();
		System.out.println("Demo 2");
		demo2();
	}

	private static void demo2() throws IOException {
		// TODO Auto-generated method stub
		String path = "C:\\Users\\Quang\\OneDrive - FPT Polytechnic\\Desktop\\fpl\\hk6\\Java6\\official\\labs\\PS36680_Lab1\\src\\main\\resources\\listStudent.json";
		ObjectMapper mapper = new ObjectMapper();
		JsonNode students = mapper.readTree(new File(path));
		students.iterator().forEachRemaining(st -> System.out.println(">> Name: " + st.get("name").asText()));
	}

	private static void demo1() throws IOException {
		// TODO Auto-generated method stub
		String path = "C:\\Users\\Quang\\OneDrive - FPT Polytechnic\\Desktop\\fpl\\hk6\\Java6\\official\\labs\\PS36680_Lab1\\src\\main\\resources\\student.json";
		ObjectMapper mapper = new ObjectMapper();
		JsonNode student = mapper.readTree(new File(path));

		System.out.println(">> Name: " + student.get("name").asText());
		System.out.println(">> Marks: " + student.get("marks").asDouble());
		System.out.println(">> Gender: " + student.get("gender").asBoolean());
		System.out.println(">> Email: " + student.get("contact").get("email").asText());
		System.out.println(">> Phone: " + student.findValue("phone").asText());
		student.get("subjects").iterator()
				.forEachRemaining(subject -> System.out.println(">> Subject: " + subject.asText()));
	}
}
