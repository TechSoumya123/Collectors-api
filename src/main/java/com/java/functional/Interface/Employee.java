package com.java.functional.Interface;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Employee {

	private Integer id;
	private String name;
	private double salary;
	private String gender;

	public boolean equals(Object object) {
		Employee employee = (Employee) object;
		return this.getId() == employee.getId();
	}
}
