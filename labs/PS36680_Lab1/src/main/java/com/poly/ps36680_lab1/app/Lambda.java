package com.poly.ps36680_lab1.app;

import com.poly.ps36680_lab1.model.Student;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Lambda {
    static List<Student> listStudents = Arrays.asList(
            new Student("S001", "Vũ Đăng Quang", true, 8.5, "quangvd@fpt.edu.vn", "Computer Science", 2),
            new Student("S002", "Vũ Thế Vinh", true, 9.0, "vinhtv@fpt.edu.vn", "Information Technology", 3),
            new Student("S003", "Nguyễn Thị Ánh Tuyết", true, 9.0, "tuyetna@fpt.edu.vn", "Software Engineering", 1),
            new Student("S004", "Vũ Hoàng Long", false, 10.0, "longvh@fpt.edu.vn", "Computer Science", 4),
            new Student("S005", "Trương Thị Minh Ngọc", true, 9.5, "ngoctm@fpt.edu.vn", "Data Science", 3)
    );


    public static void main(String[] args) {
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
    }

    private static void demo4() {
        // TODO Auto-generated method stub
//		Demo4Interface demo = new Demo4Interface() {
//			@Override
//			public void m1(int x) {
//				System.out.println(x);
//			}
//		};
//		demo.m1(2024);

        Demo4Interface demo4 = (x) -> System.out.println(x);
        demo4.m1(2024);
    }

    private static void demo3() {
//        Collections.sort(listStudents, (sv1, sv2) -> sv1.getMarks().compareTo(sv2.getMarks()));
//        listStudents.forEach(sv -> {
//            System.out.println(">> Student ID: " + sv.getStudentID());
//            System.out.println(">> Name: " + sv.getName());
//            System.out.println(">> Gender: " + (sv.getGender() ? "Male" : "Female"));
//            System.out.println(">> Marks: " + sv.getMarks());
//            System.out.println(">> Email: " + sv.getEmail());
//            System.out.println(">> Major: " + sv.getMajor());
//            System.out.println(">> Year of Study: " + sv.getYearOfStudy());
//            System.out.println();
//        });

        Collections.sort(listStudents, (sv1, sv2) -> sv1.getMarks().compareTo(sv2.getMarks()));
        listStudents.forEach(System.out::println);

        Collections.sort(listStudents, (sv1, sv2) -> sv2.getMarks().compareTo(sv1.getMarks()));
        listStudents.forEach(System.out::println);
    }

    private static void demo2() {
        listStudents.forEach(System.out::println);
    }


    private static void demo1() {
        List<Integer> list = Arrays.asList(1, 9, 4, 7, 5, 2);
        list.forEach(n -> System.out.println(n));
    }
}

@FunctionalInterface
interface Demo4Interface {
    void m1(int x);

    default void m2() {
    }

    public static void m3() {
    }
}
