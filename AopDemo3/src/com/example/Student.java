package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
	@Value("한지민")
	private String name;
	@Value("25")
	private int age;
	@Value("3")
	private int grade;
	@Value("5")
	private int classNum;

	public void getStudentInfo() {
		System.out.println("Name : " + this.name);
		System.out.println("Age : " + this.age);
		System.out.println("Grade : " + this.grade);
		System.out.println("Class : " + this.classNum);
	}
}
