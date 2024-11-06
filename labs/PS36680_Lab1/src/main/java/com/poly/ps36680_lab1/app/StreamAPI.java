package com.poly.ps36680_lab1.app;

import com.poly.ps36680_lab1.model.Student;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Stream;


public class StreamAPI {
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
        OptionalDouble average = listStudents.stream().mapToDouble(Student::getMarks).average();
        double avg = average.isPresent() ? average.getAsDouble() : 0;
        System.out.println("Average: " + avg);

        double sum = listStudents.stream().mapToDouble(Student::getMarks).sum();
        System.out.println("Sum: " + sum);

        double min_mark = listStudents.stream().mapToDouble(Student::getMarks).min().orElse(0);
        System.out.println("Min: " + min_mark);

        boolean all_match = listStudents.stream().allMatch(sv -> sv.getMarks() >= 9.0);
        System.out.println("All pass: " + all_match);

        Student min_sv = listStudents.stream().reduce(listStudents.get(0),
                (min, sv) -> sv.getMarks() < min.getMarks() ? sv : min);
        System.out.println("Min sv: " + min_sv);
    }

    private static void demo3() {
        List<Student> list = listStudents.stream()
                .filter(sv -> sv.getMarks() > 9.0)
                .peek(sv -> sv.setName(sv.getName().toUpperCase()))  // Convert name to uppercase
                .toList();

        list.forEach(sv -> {
            System.out.println(">> Student ID: " + sv.getStudentID());
            System.out.println(">> Name: " + sv.getName());
            System.out.println(">> Gender: " + (sv.getGender() ? "Male" : "Female"));
            System.out.println(">> Marks: " + sv.getMarks());
            System.out.println(">> Email: " + sv.getEmail());
            System.out.println(">> Major: " + sv.getMajor());
            System.out.println(">> Year of Study: " + sv.getYearOfStudy());
            System.out.println();
        });
    }

    private static void demo2() {
        List<Integer> list = Arrays.asList(1, 9, 4, 7, 5, 2);
        List<Double> result = list.stream().filter(i -> i % 2 == 0).map(Math::sqrt)
                .peek(System.out::println).toList();
    }

    private static void demo1() {
        Stream<Integer> stream1 = Stream.of(1, 9, 4, 7, 5, 2);
        stream1.forEach(x -> System.out.print(x + " "));
        System.out.println();

        List<Integer> list = Arrays.asList(1, 9, 4, 7, 5, 2);
//        list.stream().forEach(x -> System.out.print(x + " "));
        list.forEach(x -> System.out.print(x + " "));
    }
}
