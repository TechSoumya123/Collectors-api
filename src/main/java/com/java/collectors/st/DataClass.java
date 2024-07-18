package com.java.collectors.st;

import java.util.List;
import java.util.Map;

public class DataClass {

	private DataClass() {
	}

	public static List<Student> fetchAllStudents() {
		return List.of(

				new Student(101, "smith", 34, 1234455, Map.of("GK", 61, "Math", 56, "History", 77, "Eng", 46)),
				new Student(102, "Tim", 43, 3334455, Map.of("GK", 88, "Math", 67, "History", 70, "Eng", 64)),
				new Student(103, "Josh", 30, 44434455, Map.of("GK", 80, "Math", 38, "History", 37, "Eng", 36)),
				new Student(104, "Josh", 34, 66634455, Map.of("GK", 37, "Math", 86, "History", 50, "Eng", 47)),
				new Student(105, "Cook", 87, 777898, Map.of("GK", 83, "Math", 55, "History", 59, "Eng", 56)),
				new Student(106, "Marry", 78, 1111898, Map.of("GK", 82, "Math", 59, "History", 58, "Eng", 68))

		);
	}

}
