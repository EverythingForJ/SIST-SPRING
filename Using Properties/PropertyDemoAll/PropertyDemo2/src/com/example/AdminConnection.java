package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Component("adminConnection")
public class AdminConnection {
	@Value("${admin.id}")
	private String adminId;
	
	@Value("${admin.pwd}")
	private String adminPwd;
	
	@Value("${sub.admin.id}")
	private String subAdminId;
	
	@Value("${sub.admin.pwd}")
	private String subAdminPwd;
	
}
