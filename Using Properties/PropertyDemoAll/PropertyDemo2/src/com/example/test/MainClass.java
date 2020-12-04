package com.example.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.AdminConnection;
import com.example.ApplicationConfig;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		AdminConnection connection = (AdminConnection) context.getBean("adminConnection");
		System.out.println("admin ID : " + connection.getAdminId());
		System.out.println("admin PWD : " + connection.getAdminPwd());
		System.out.println("sub admin ID : " + connection.getSubAdminId());
		System.out.println("sub admin PWD : " + connection.getSubAdminPwd());
	}
}
