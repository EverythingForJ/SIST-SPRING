package com.example;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Setter
@ToString
public class Student{
	private String name;
	private int age;
	private String gender;
	private String city;
}
