package com.example;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
public class StudentInfo {
	private Student student;

	public void printInfo() {
		if (this.student != null) {
			System.out.println("Name : " + this.student.getName());
			System.out.println("Age : " + this.student.getAge());
			System.out.println("Grade : " + this.student.getGrade());
			System.out.println("Class : " + this.student.getClassNum());
			System.out.println("-------------------------");
		}
	}
}
