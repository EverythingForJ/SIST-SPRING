package com.example;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Select dev or run : ");
		String config = scan.next(); // "dev" or "run"

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);
		ctx.register(ApplicationConfigDev.class, ApplicationConfigRun.class);
		ctx.refresh();
		
		ServerInfo info = ctx.getBean("serverInfo", ServerInfo.class);
		System.out.println("IP : " + info.getIpNum());
		System.out.println("Port : " + info.getPortNum());
		ctx.close();
	}
}
