package com.java.collectors.st;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Student {

	private Integer rollNo;
	private String name;
	private int age;
	private long phone;
	private Map<String, Integer> marks;
	
	
}
