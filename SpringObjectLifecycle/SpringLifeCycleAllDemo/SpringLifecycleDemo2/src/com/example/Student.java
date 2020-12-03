package com.example;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Student /* implements InitializingBean, DisposableBean */{
	private String name;
	private int age;
	private String gender;
	private String city;

	@PostConstruct
	public void initMethod() {
		System.out.println("방금 Bean이 생성됐습니다.");
	}
	
	@PreDestroy
	public void destroyMethod() {
		System.out.println("방금 Bean이 소멸됐습니다.");
	}
	
	
//	@Override
//	public void destroy() throws Exception {
//		System.out.println("방금 Bean이 소멸됐습니다.");
//	}
//
//	@Override
//	public void afterPropertiesSet() throws Exception {
//		System.out.println("방금 Bean이 생성됐습니다.");
//	}
}
