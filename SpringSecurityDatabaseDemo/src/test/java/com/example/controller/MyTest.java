package com.example.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.service.UserRolesService;
import com.example.service.UserService;
import com.example.vo.UserRolesVO;
import com.example.vo.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
class MyTest {
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private PasswordEncoder customPasswordEncoder;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRolesService userRolesService;
	
	@Disabled @Test
	void test() {
		//assertNotNull(this.sqlSession);
		assertNotNull(this.customPasswordEncoder);
	}
	
	@Disabled @Test
	public void test1() {
		Date today = (Date)this.sqlSession.selectOne("Users.currentDate");
		log.warn("Today = " + today.toLocaleString());
	}
	
	@Disabled @Test
	public void test2() {
		
//		UserVO user = new UserVO(); 
//		user.setUserid("jimin");
//		user.setPasswd(this.customPasswordEncoder.encode("12345678"));
//		user.setName("한지민"); 
//		user.setEnabled(1); 
//		this.userService.insertUser(user);
		 
		
//		UserVO user = new UserVO();
//		user.setUserid("alex");
//		user.setPasswd(this.customPasswordEncoder.encode("12345678"));
//		user.setName("김지민");
//		user.setEnabled(1);
//		this.userService.insertUser(user);
		
	}
	
	@Test
	public void test3() {
//		UserRolesVO userRoles = new UserRolesVO();
//		userRoles.setUserid("jimin");
//		userRoles.setRole("ROLE_USER");
//		
//		this.userRolesService.insertRoles(userRoles);
		
		UserRolesVO userRoles = new UserRolesVO();
		userRoles.setUserid("jimin");
		userRoles.setRole("ROLE_ADMIN");
		
		this.userRolesService.insertRoles(userRoles);
	}

}


//INSERT INTO user_roles (user_role_id, username, role)
//VALUES (seq_user_role_id.NEXTVAL, 'javaexpert', 'ROLE_USER');
//INSERT INTO user_roles (user_role_id, username, role)
//VALUES (seq_user_role_id.NEXTVAL, 'javaexpert', 'ROLE_ADMIN');