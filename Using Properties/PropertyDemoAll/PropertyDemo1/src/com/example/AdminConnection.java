package com.example;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AdminConnection /* implements InitializingBean, DisposableBean */{
	private String adminId;
	private String adminPwd;
	private String subAdminId;
	private String subAdminPwd;
	
//	@Override
//	public void afterPropertiesSet() throws Exception {
//		System.out.println("객체가 방금 초기화됐습니다.");
//	}
//
//	@Override
//	public void destroy() throws Exception {
//		System.out.println("객체가 방금 소멸됐습니다.");
//	}
	
	@PostConstruct
	public void myInit() {
		System.out.println("객체가 방금 초기화됐습니다.");
	}
	
	@PreDestroy
	public void myDestroy() {
		System.out.println("객체가 방금 소멸됐습니다.");
	}
	
}
