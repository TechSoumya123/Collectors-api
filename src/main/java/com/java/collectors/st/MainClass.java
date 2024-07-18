package com.java.collectors.st;

import static java.lang.System.out;

import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

public class MainClass {

	final static Logger logger = Logger.getLogger(MainClass.class.getName());

	public static void main(String[] args) {

		List<Student> fetchAllStudents = DataClass.fetchAllStudents();

		fetchAllStudents.forEach(out::println);

		logger.info("-------------------------------------------------------------------------");

		fetchAllStudents.stream().filter(student -> student.getAge() > 50).forEach(System.out::println);

		logger.info("-------------------------------------------------------------------------");

		fetchAllStudents.stream().filter(student -> student.getName().endsWith("m")).forEach(out::println);

		logger.info("-------------------------------------------------------------------------");

		fetchAllStudents.stream().map(Student::getName).map(String::toUpperCase).forEach(System.out::println);

		logger.info("-------------------------------------------------------------------------");

		fetchAllStudents.stream().filter(student -> student.getName().startsWith("J")).forEach(out::println);

		logger.info("-------------------------------------------------------------------------");

		fetchAllStudents.stream().sorted(Comparator.comparing(Student::getAge).thenComparing(Student::getName))
				.forEach(out::println);

		logger.info("-------------------------------------------------------------------------");

		fetchAllStudents.stream()
				.sorted(Comparator.comparing(Student::getAge).thenComparing(Student::getName).reversed())
				.forEach(out::println);

		logger.info("-------------------------------------------------------------------------");

		fetchAllStudents.stream().map(student -> new Student(student.getRollNo(), student.getName().toUpperCase(),
				student.getAge(), student.getPhone(), student.getMarks())).forEach(out::println);

		logger.info("-------------------------------------------------------------------------");

		fetchAllStudents.stream().map(student -> student.getRollNo() + " " + student.getName().toUpperCase() + " "
				+ student.getAge() + " " + student.getPhone() + " " + student.getMarks()).forEach(out::println);

		logger.info("-------------------------------------------------------------------------");

		fetchAllStudents.stream().map(Student::getMarks).forEach(out::println);

		logger.info("-------------------------------------------------------------------------");

		fetchAllStudents.stream().map(student -> student.getMarks().values().stream().reduce(Integer::sum))
				.forEach(out::println);

		logger.info("-------------------------------------------------------------------------");

		Integer integer = fetchAllStudents.stream()
				.map(student -> student.getMarks().values().stream().reduce(0, (a, b) -> a + b)).max(Integer::compareTo)
				.get();
		System.out.println(integer);

		Integer integer2 = fetchAllStudents.stream()
				.map(student -> student.getMarks().values().stream().reduce(0, (a, b) -> a + b)).min(Integer::compareTo)
				.get();
		System.out.println(integer2);

		logger.info("-------------------------------------------------------------------------");

		fetchAllStudents.stream().filter(s -> s.getName().equals("Marry")).toList().stream()
				.map(s -> s.getMarks().get("History")).forEach(out::println);

	}

}
