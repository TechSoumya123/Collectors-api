package com.java.collectors.emp;

import static java.lang.System.out;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainClass {

	final static Logger logger = Logger.getLogger(MainClass.class.getName());

	public static void main(String[] args) {

		List<Employee> allEmployees = DataClass.fetchAllEmployees();

		logger.info("-----------------------------------------------------------------");

		allEmployees.forEach(out::println);

		logger.info("-----------------------------------------------------------------");

		allEmployees.stream().filter(employee -> employee.city().equals("USA")).forEach(out::println);

		logger.info("-----------------------------------------------------------------");

		allEmployees.stream().filter(emp -> emp.city().equals("USA")).map(Employee::name).forEach(out::println);

		logger.info("-----------------------------------------------------------------");

		Map<String, List<Employee>> collect = allEmployees.stream().collect(Collectors.groupingBy(Employee::city));

		collect.forEach((k, v) -> System.out.printf("%8s: %s%n", k, v));

		logger.info("-----------------------------------------------------------------");

		Map<String, Long> collect2 = allEmployees.stream()
				.collect(Collectors.groupingBy(Employee::city, Collectors.counting()));
		for (String item : collect2.keySet()) {
			System.out.println(item + " : " + collect2.get(item));
		}

		logger.info("-----------------------------------------------------------------");

		Map<String, List<String>> collect3 = allEmployees.stream()
				.collect(Collectors.groupingBy(Employee::city, mapping(Employee::name, toList())));
		out.println(collect3);

		logger.info("-----------------------------------------------------------------");

		HashMap<String, List<String>> collect4 = allEmployees.stream().collect(
				Collectors.groupingBy(Employee::city, HashMap::new, Collectors.mapping(Employee::name, toList())));
		out.println(collect4);

		logger.info("-----------------------------------------------------------------");

		Map<String, Set<String>> collect5 = allEmployees.stream()
				.collect(Collectors.groupingBy(Employee::department, mapping(Employee::name, toSet())));
		for (String item : collect5.keySet()) {
			out.println(item + ">>>" + collect5.get(item));
		}

		logger.info("-----------------------------------------------------------------");
		
		allEmployees.stream()
				.collect(Collectors.groupingBy(Employee::department,
						Collectors.filtering(e -> e.city().equals("USA"), toList())))
				.forEach((k, v) -> System.out.printf("%8s: %s%n", k, v));
		
		logger.info("-----------------------------------------------------------------");
		
		Map<String, List<String>> collect6 = allEmployees.stream().filter(e -> e.city().equals("USA"))
				.collect(Collectors.groupingBy(Employee::city, mapping(Employee::name, toList())));
		collect6.forEach((k, v) -> System.out.printf("%8s: %s%n", k, v));
		
		logger.info("-----------------------------------------------------------------");
		
		for (String item : collect6.keySet()) {
			out.println(item + ">>>" + collect6.get(item));
		}
		logger.info("-----------------------------------------------------------------");
		
		List<Integer> listOfIntegers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 9);
		Stream<Integer> map = listOfIntegers.stream().filter(e -> e > 2).map(e -> e * 2);
		map.forEach(out::println);
	}

}
