package com.java.collectorse;

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
	}

}
