package com.java.collectors.str;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainClass {

	final static Logger logger = Logger.getLogger(MainClass.class.getName());

	public static void main(String[] args) {
		
		Stream<Object> emptyStrem = Stream.empty();
		out.println(emptyStrem.count());

		logger.info("-------------------------------------------------------------------");
		// of(T t)
		Stream<String> streamOfObject = Stream.of("One");
		streamOfObject.filter(element -> element.length() > 2).map(ele -> ele.toUpperCase()).forEach(out::println);

		logger.info("-------------------------------------------------------------------");
		// of(T... values)
		Stream<String> streamOfString = Stream.of("One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
				"Nine", "Ten");

		streamOfString.filter(e -> e.length() > 3).map(e -> e.length()).forEach(out::println);

		logger.info("-------------------------------------------------------------------");

		Stream<String> build = Stream.<String>builder().add("One").add("Two").add("Three").build();
		build.forEach(out::println);

		logger.info("-------------------------------------------------------------------");

		List<Integer> list = Stream.iterate(0, i -> i < 10, i -> i + 1).toList();
		list.forEach(out::println);

		logger.info("-------------------------------------------------------------------");

		List<Integer> asList = Arrays.asList(100, 20, 30, 50);
		Stream<Integer> stream = asList.stream();
		List<Integer> list2 = stream.filter(p -> p > 30).toList();
		out.println(list2);

		logger.info("-------------------------------------------------------------------");

		ArrayList<String> stringArraysList = new ArrayList<>();
		stringArraysList.add("One");
		stringArraysList.add("Two");
		stringArraysList.add("Three");
		stringArraysList.add("Four");

		Stream<String> stream2 = stringArraysList.stream();

		stream2.map(String::toUpperCase).forEach(out::println);
		logger.info("-------------------------------------------------------------------");

		Integer[] array = { 8, 4, 9, 2, 6 };

		Stream.of(array).filter(e -> e > 4).findFirst();

		int[] array1 = { 8, 4, 9, 2, 6 };
		Arrays.stream(array1).filter(e -> e > 4).findFirst();

		Arrays.stream(array1).sorted().forEach(out::println);

		logger.info("-------------------------------------------------------------------");

		
		IntStream stream3 = Arrays.stream(array1);

		
		Stream<Integer> boxed = Arrays.stream(array1).boxed(); // Convert IntStream to Stream(If i not use boxed method
																// i cannot use toList method which is present inside
																// the collector interface ->Collectors.tolist())

		List<Integer> list3 = Arrays.stream(array1).boxed().toList(); //
		out.println(list3);

		logger.info("-------------------------------------------------------------------");

		String[] names = { "Soumya", "Sintu", "Mondal" };
		Arrays.stream(names).filter(name -> name.length() > 5).map(name -> name.toUpperCase())
				.forEach(s -> out.println(s));

	}

}
