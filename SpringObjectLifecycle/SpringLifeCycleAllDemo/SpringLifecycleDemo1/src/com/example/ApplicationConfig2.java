package com.example;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig2 {
	@Bean
	public Student student4() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("그림그리기");
		list.add("프로그래밍");
		Student student4 = new Student("배지민", 38, list);
		student4.setHeight(173.8);
		student4.setWeight(66.2);
		return student4;
	}
}
