package com.java.collectors;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MainClass {

	final static Logger logger = Logger.getLogger(MainClass.class.getName());

	public static void main(String[] args) {

		ArrayList<String> listOfIntegers = new ArrayList<>();
		listOfIntegers.add("One");
		listOfIntegers.add("Two");
		listOfIntegers.add("Three");
		listOfIntegers.add("Four");
		listOfIntegers.add(null);

		logger.info(String.valueOf(listOfIntegers));

		logger.info("-------------------------------------------------------------------");

		listOfIntegers.add(2, "THREE");
		logger.info(String.valueOf(listOfIntegers));

		logger.info("-------------------------------------------------------------------");

		listOfIntegers.add(2, "NewValue");
		logger.info(String.valueOf(listOfIntegers));

		logger.info("-------------------------------------------------------------------");

		listOfIntegers.add(0, "THREE");
		logger.info(String.valueOf(listOfIntegers));

		logger.info("-------------------------------------------------------------------");

		listOfIntegers.add(0, "NewValue");
		logger.info(String.valueOf(listOfIntegers));

		logger.info("-------------------------------------------------------------------");

		listOfIntegers.add("ok");
		logger.info(String.valueOf(listOfIntegers));

		logger.info("-------------------------------------------------------------------");

		boolean contains = listOfIntegers.contains("o");
		logger.info(String.valueOf(contains));

		logger.info("-------------------------------------------------------------------");

		List<Integer> setOfNumbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		for (int i = 0; i < setOfNumbers.size(); i++) {
			int n = setOfNumbers.get(i);
			if (n % 2 == 0) {
				out.println(n);
			}
		}
		logger.info("-------------------------------------------------------------------");
		List<Integer> list = setOfNumbers.stream().filter(num -> num % 2 == 0).toList();
		logger.info(String.valueOf(list));
	}
}
