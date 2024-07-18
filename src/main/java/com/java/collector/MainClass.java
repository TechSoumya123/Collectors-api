package com.java.collector;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class MainClass {

	final static Logger logger = Logger.getLogger(MainClass.class.getName());

	public static void main(String[] args) {

		IntStream intStream = IntStream.rangeClosed(1, 200);

		logger.info("-------------------------------------------------------------------");

		List<Integer> listOfIntegers = intStream.boxed().toList();

		logger.info("-------------------------------------------------------------------");

		Optional<Integer> reducelistMappingData = listOfIntegers.stream().filter(e -> e % 2 == 0).map(num -> num * 2)
				.reduce(Integer::sum);

		System.out.println(reducelistMappingData.get());

		logger.info("-------------------------------------------------------------------");

		listOfIntegers.stream().takeWhile(o -> o < 20).forEach(System.out::println);

		logger.info("-------------------------------------------------------------------");

		listOfIntegers.stream().dropWhile(o -> o < 20).forEach(System.out::println);
		
		logger.info("-------------------------------------------------------------------");
		
		Optional<Integer> max = listOfIntegers.stream().max(Comparator.comparing(e -> e));
		System.out.println(max.get());

	}

}
