package com.java.collectors_;

import java.util.List;
import java.util.logging.Logger;

import static java.lang.System.out;

public class MainClass {

	final static Logger logger = Logger.getLogger(MainClass.class.getName());

	public static void main(String[] args) {

		List<String> listOfString = List.of("One","Two","Three","Four","Five","Six","Seven");

		logger.info("-------------------------------------------------------------------");
		
		listOfString.stream().forEach(out::println);
		
	}

}
