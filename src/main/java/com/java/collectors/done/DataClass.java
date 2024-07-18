package com.java.collectors.done;

import java.util.List;

public class DataClass {

	private DataClass() {
	}

	public static List<Employee> fetchAllEmployees() {
		return List.of(new Employee(100, "Smith", 45, 34000, "CS", "Delhi"),
				new Employee(101, "John", 32, 52000, "IT", "Dhaka"), 
				new Employee(102, "Corey", 28, 36000, "IT", "USA"),
				new Employee(103, "Marry", 28, 68000, "CS", "USA"),
				new Employee(104, "Zenith", 45, 18000, "FIN", "USA"),
				new Employee(106, "Tom", 68, 48000, "GEN", "CHINA"),
				new Employee(106, "Tom", 61, 78000, "GEN", "CHINA"),
				new Employee(107, "Tim", 21, 28000, "IT", "ENGLAND"),
				new Employee(108, "Sumo", 29, 29000, "FIN", "JAPAN"),
				new Employee(109, "Samu", 32, 9200, "CS", "JAPAN"),
				new Employee(110, "Jonoy", 60, 48000, "GEN", "JAPAN"));
	}

}