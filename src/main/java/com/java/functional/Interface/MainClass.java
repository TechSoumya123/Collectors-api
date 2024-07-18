package com.java.functional.Interface;

import static java.lang.System.out;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class MainClass {

	final static Logger logger = Logger.getLogger(MainClass.class.getName());

	public static void main(String[] args) {

		Function<Integer, Double> functionExample = i -> i / 2.0;
		out.println(functionExample.apply(10));

		logger.info("-------------------------------------------------------------------");

		Function<String, String> upperCase = String::toUpperCase;
//		out.println(upperCase.apply("Soumya"));

		logger.info("-------------------------------------------------------------------");

		Function<String, String> uppercase2 = string -> string == null ? "Enter valid String" : string.toLowerCase();

		out.println(uppercase2.andThen(upperCase).apply("Soumya"));

		logger.info("-------------------------------------------------------------------");

		out.println(uppercase2.compose(upperCase).apply("Soumya"));

		logger.info("-------------------------------------------------------------------");

		// static identity()
		Function<Integer, Integer> identityValue = Function.identity();
		out.println(identityValue.apply(100));

		logger.info("-------------------------------------------------------------------");

		// Stream API
		// Stream Object : From that i have to collect all values as a List.

		Stream<String> names = Stream.of("One", "Two", "Three");
		List<String> collect = names.map(Function.identity()).collect(toList());
		out.println(collect);
		
		logger.info("-------------------------------------------------------------------");

		Predicate<Integer> ageCheck = age -> age > 21;

		out.println(ageCheck.test(22));

		logger.info("-------------------------------------------------------------------");

		if (ageCheck.test(26)) {
			out.println("Eliible");
		}

		logger.info("-------------------------------------------------------------------");

		Employee employee1 = new Employee();
		employee1.setId(111);
		employee1.setSalary(24000);
		employee1.setGender("Female");

		Predicate<Employee> empSalary = emp -> emp.getSalary() > 25000;

		if (empSalary.test(employee1)) {
			out.println("Above 2500000");
		} else {
			out.println("Below 25000");
		}

		logger.info("-------------------------------------------------------------------");

		Predicate<Employee> empGender = emp -> emp.getGender().equalsIgnoreCase("female");

		if (empSalary.and(empGender).test(employee1)) {
			out.println("Both are true");
		} else {
			out.println("Check the value which is given by you..");
		}

		logger.info("-------------------------------------------------------------------");

		BiPredicate<Integer, String> salaryANDgender = (Integer empSalaryo, String empGendero) -> empSalaryo > 25000
				& empGendero.equalsIgnoreCase("Male");
		out.println(salaryANDgender.test(25500, "male"));

		logger.info("-------------------------------------------------------------------");

		Predicate<Employee> emPredicate = Predicate.isEqual(employee1);

		Employee employee2 = new Employee();
		employee2.setId(123);
		employee2.setSalary(24000);
		employee2.setGender("Male");

		out.println(emPredicate.test(employee2));

		logger.info("-------------------------------------------------------------------");

		List<String> listOfNames = List.of("abc", "jewkj", "jkdwjk", "wjdiq");
		Consumer<String> toUpperCase = str -> out.println(str.toUpperCase());

		listOfNames.forEach(toUpperCase);

		List<String> listAdd = new ArrayList<>();

		Consumer<String> acceptList = str -> listAdd.add(str.toUpperCase());

		listOfNames.forEach(acceptList);
		
		out.println(listAdd);
	}

}
