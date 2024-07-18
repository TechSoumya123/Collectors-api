package com.java.collectors.done;

import static java.lang.System.out;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class MainClass {

	final static Logger logger = Logger.getLogger(MainClass.class.getName());

	public static void main(String[] args) {

		List<Employee> fetchAllEmployees = DataClass.fetchAllEmployees();
		fetchAllEmployees.forEach(out::println);

		logger.info("-------------------------------------------------------------------");

		List<Employee> collect = fetchAllEmployees.stream().filter(employee -> employee.department().equals("IT"))
				.collect(Collectors.toList());
		collect.forEach(out::println);

		logger.info("-------------------------------------------------------------------");

		String collect2 = fetchAllEmployees.stream().map(emp -> emp.name()).collect(Collectors.joining());
		System.out.println(collect2);

		logger.info("ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");

		String collect3 = fetchAllEmployees.stream().map(emp -> emp.name()).collect(Collectors.joining(","));
		System.out.println(collect3);

		logger.info("-------------------------------------------------------------------");

		String collect4 = fetchAllEmployees.stream().map(emp -> emp.name())
				.collect(Collectors.joining(" - ", "{ ", " }"));
		System.out.println(collect4);
		
		logger.info("-------------------------------------------------------------------");

		List<Employee> list = fetchAllEmployees.stream().filter(emp -> emp.name().contains("i")).toList();
		list.forEach(out::println);

	}

}
