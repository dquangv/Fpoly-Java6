package com.poly.ps36680_lab1.app;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.poly.ps36680_lab1.model.Contact;
import com.poly.ps36680_lab1.model.Student2;


public class Jackson2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Demo 1");
		demo1();
		System.out.println();
		System.out.println("Demo 2");
		demo2();
		System.out.println();
		System.out.println("Demo 3");
		demo3();
		System.out.println();
		System.out.println("Demo 4");
		demo4();
		System.out.println();
		System.out.println("Demo 5");
		demo5();
		System.out.println();
		System.out.println("Demo 6");
		demo6();
		System.out.println();
		System.out.println("Demo 7");
		demo7();
	}

	private static void demo7() throws IOException {
		// TODO Auto-generated method stub
		Contact contact = new Contact("tranthib@gmail.com", "0987654321", null);
		List<String> subjects = Arrays.asList("WEB103", "SOF3031");
		Student2 student = new Student2("Trần Thị B", false, 7.0, contact, subjects);
		ObjectMapper mapper = new ObjectMapper();
		// Write to string
		String json = mapper.writeValueAsString(student);
		System.out.println(json);
		// Write to output
		mapper.writerWithDefaultPrettyPrinter().writeValue(System.out, student);
		// Write to file
		mapper.writeValue(new File("C:\\Users\\Quang\\OneDrive - FPT Polytechnic\\Desktop\\fpl\\hk6\\Java6\\official\\labs\\PS36680_Lab1\\src\\main\\resources\\staff5.json"), student);
	}

	private static void demo6() throws IOException {
		// TODO Auto-generated method stub
		Map<String, Object> contact = new HashMap<String, Object>();
		contact.put("email", "teonv@gmail.com");
		contact.put("phone", "0909987654");

		List<String> subjects = Arrays.asList("WEB103", "SOF3031");

		Map<String, Object> student = new HashMap<String, Object>();
		student.put("name", "Nguyễn Văn Tèo");
		student.put("marks", 7.5);
		student.put("gender", true);
		student.put("contact", contact);
		student.put("subjects", subjects);
		ObjectMapper mapper = new ObjectMapper();
		// Write to string
		String json = mapper.writeValueAsString(student);
		System.out.println(json);
		// Write to output
		mapper.writerWithDefaultPrettyPrinter().writeValue(System.out, student);
		// Write to file
		mapper.writeValue(new File("C:\\Users\\Quang\\OneDrive - FPT Polytechnic\\Desktop\\fpl\\hk6\\Java6\\official\\labs\\PS36680_Lab1\\src\\main\\resources\\staff4.json"), student);
	}

	private static void demo5() throws IOException {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode student = mapper.createObjectNode();
		student.put("name", "Nguyễn Văn A");
		student.put("marks", 8.0);
		student.put("gender", false);
		ObjectNode contactNode = student.putObject("contact");
		contactNode.put("email", "nguyenvana@gmail.com");
		contactNode.put("phone", "0909123456");
		ArrayNode subjectsNode = student.putArray("subjects");
		subjectsNode.add("SOF306");
		subjectsNode.add("COM2024");

		// Write to string
		String json = mapper.writeValueAsString(student);
		System.out.println(json);
		// Write to output
		mapper.writeValue(System.out, student);

		// Write to file
		mapper.writeValue(new File("C:\\Users\\Quang\\OneDrive - FPT Polytechnic\\Desktop\\fpl\\hk6\\Java6\\official\\labs\\PS36680_Lab1\\src\\main\\resources\\staff3.json"), student);
	}

	private static void demo4() throws Exception {
		// TODO Auto-generated method stub
		String path = "C:\\Users\\Quang\\OneDrive - FPT Polytechnic\\Desktop\\fpl\\hk6\\Java6\\official\\labs\\PS36680_Lab1\\src\\main\\resources\\listStudent.json";
		TypeReference<List<Student2>> type = new TypeReference<List<Student2>>() {
		};
		ObjectMapper mapper = new ObjectMapper();
		List<Student2> list = mapper.readValue(new File(path), type);
		list.forEach(st -> System.out.println(">> Name: " + st.getName()));
	}

	private static void demo3() throws Exception {
		// TODO Auto-generated method stub
		String path = "C:\\Users\\Quang\\OneDrive - FPT Polytechnic\\Desktop\\fpl\\hk6\\Java6\\official\\labs\\PS36680_Lab1\\src\\main\\resources\\student.json";
		ObjectMapper mapper = new ObjectMapper();
		Student2 student = mapper.readValue(new File(path), Student2.class);

		System.out.println(">> Name: " + student.getName());
		System.out.println(">> Marks: " + student.getMarks());
		System.out.println(">> Gender: " + student.getGender());
		Contact contact = student.getContact();
		System.out.println(">> Email: " + contact.getEmail());
		System.out.println(">> Phone: " + contact.getPhone());
		List<String> subjects = student.getSubjects();
		subjects.forEach(sj -> System.out.println(">> Subjects: " + sj));
	}

	private static void demo2() throws StreamReadException, DatabindException, IOException {
		// TODO Auto-generated method stub
		String path = "C:\\Users\\Quang\\OneDrive - FPT Polytechnic\\Desktop\\fpl\\hk6\\Java6\\official\\labs\\PS36680_Lab1\\src\\main\\resources\\listStudent.json";
		ObjectMapper mapper = new ObjectMapper();
		List<Map<String, Object>> list = mapper.readValue(new File(path), List.class);
		list.forEach(st -> System.out.println(">> Name: " + st.get("name")));
	}

	private static void demo1() throws Exception {
		// TODO Auto-generated method stub
		String path = "C:\\Users\\Quang\\OneDrive - FPT Polytechnic\\Desktop\\fpl\\hk6\\Java6\\official\\labs\\PS36680_Lab1\\src\\main\\resources\\student.json";
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> student = mapper.readValue(new File(path), Map.class);

		System.out.println(">> Name: " + student.get("name"));
		System.out.println(">> Marks: " + student.get("marks"));
		System.out.println(">> Gender: " + student.get("gender"));
		Map<String, Object> contact = (Map<String, Object>) student.get("contact");
		System.out.println(">> Email: " + contact.get("email"));
		System.out.println(">> Phone: " + contact.get("phone"));
		List<String> subjects = (List<String>) student.get("subjects");
		subjects.forEach(sj -> System.out.println(">> Subjects: " + sj));
	}

}
