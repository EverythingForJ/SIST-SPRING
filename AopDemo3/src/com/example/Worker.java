package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Worker {
	@Value("김지민")
	private String name;
	@Value("28")
	private int age;
	@Value("개발자")
	private String job;

	public void getWorkerInfo() {
		System.out.println("Name : " + this.name);
		System.out.println("Age : " + this.age);
		System.out.println("Job : " + this.job);
	}
}
