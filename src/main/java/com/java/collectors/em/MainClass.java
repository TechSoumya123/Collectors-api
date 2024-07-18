package com.java.collectors.em;

import static java.lang.System.out;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.var;

public class MainClass {

	final static Logger logger = Logger.getLogger(MainClass.class.getName());

	public static void main(String[] args) {

		List<Employee> fetchAllEmployees = DataClass.fetchAllEmployees();
		fetchAllEmployees.forEach(out::println);

		logger.info("-------------------------------------------------------------------");

		List<Employee> listEmployees = fetchAllEmployees.stream().filter(employee -> employee.age() > 50)
				.collect(Collectors.toList());
		listEmployees.forEach(out::println);

		logger.info("-------------------------------------------------------------------");

		Set<Employee> collect = fetchAllEmployees.stream().filter(employee -> employee.age() > 50)
				.collect(Collectors.toSet());
		collect.forEach(out::println);

		logger.info("-------------------------------------------------------------------");

		Map<Integer, String> collect2 = fetchAllEmployees.stream()
				.collect(Collectors.toMap(Employee::id, Employee::name, (oldValue, newValue) -> newValue));

		collect2.forEach((k, v) -> out.printf("%8s: %s%n", k, v));

		logger.info("-------------------------------------------------------------------");

		Map<Integer, Employee> collect3 = fetchAllEmployees.stream()
				.collect(Collectors.toMap(Employee::id, e -> e, (oldValue, newValue) -> newValue));
		for (var item : collect3.keySet()) {
			out.println(item + " )))))))) " + collect3.get(item));
		}

		logger.info("-------------------------------------------------------------------");

		Long collect4 = fetchAllEmployees.stream().collect(Collectors.counting());
		out.println(collect4);

		logger.info("-------------------------------------------------------------------");

		Optional<Employee> collect5 = fetchAllEmployees.stream()
				.collect(Collectors.maxBy(Comparator.comparing(Employee::salary)));
		collect5.ifPresentOrElse(out::println, () -> out.println("No Heighest salary is present"));

		logger.info("-------------------------------------------------------------------");

		Optional<Employee> maxSalary = fetchAllEmployees.stream().max(Comparator.comparing(Employee::salary));
		maxSalary.ifPresentOrElse(out::println, () -> out.println("No Heighest salary is present"));

		logger.info("-------------------------------------------------------------------");

		Map<Boolean, List<Employee>> collect6 = fetchAllEmployees.stream()
				.collect(Collectors.partitioningBy(emp -> emp.age() > 50));
		out.println(collect6);

		logger.info("-------------------------------------------------------------------");

		Map<Boolean, Set<Employee>> collect7 = fetchAllEmployees.stream()
				.collect(Collectors.partitioningBy(emp -> emp.age() > 50, Collectors.toSet()));

		collect7.forEach((k, v) -> out.printf("%8s :%s%n", k, v));

		logger.info("-------------------------------------------------------------------");

		Map<Boolean, Set<Employee>> collect8 = fetchAllEmployees.stream()
				.collect(Collectors.partitioningBy(emp -> emp.age() > 50, Collectors.toSet()));
		for (var key : collect8.keySet()) {
			out.println("---------------------------" + key + "------------------");
			collect8.get(key).stream().forEach(out::println);
		}

		logger.info("-------------------------------------------------------------------");

		Map<Boolean, List<Integer>> collect9 = Stream.iterate(1, i -> i < 50, n -> n + 1)
				.collect(Collectors.partitioningBy(num -> num % 2 == 0));
		for (var item : collect9.keySet()) {
			System.out.println(item + " : " + collect9.get(item));
		}
		
		logger.info("-------------------------------------------------------------------");

		Stream.iterate(1, i -> i < 50, n -> n + 1).collect(Collectors.partitioningBy(num -> num % 2 == 0))
				.forEach((k, v) -> out.printf("%s :%s%n", k, v));

	}

}
