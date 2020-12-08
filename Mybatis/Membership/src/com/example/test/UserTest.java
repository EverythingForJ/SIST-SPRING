package com.example.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.config.ApplicationConfig;
import com.example.service.UserService;
import com.example.vo.UserVO;

import lombok.extern.java.Log;

@ExtendWith(SpringExtension.class)
//@ContextConfiguration(locations = { "classpath:beans.xml" })
@ContextConfiguration(classes = {ApplicationConfig.class})
@Log
class UserTest {
	@Autowired
	private UserService userService;

	@Test
	public void test() {
		UserVO user = this.userService.getUser("jimin");
		log.info(user.toString());
		assertEquals("한지민", user.getName());
	}

	@Disabled @Test
	public void test1() {
		this.userService.insertUser(new UserVO("dooly", "둘리", "남", "경기"));
		
		List<UserVO> list = this.userService.getUserList();
		list.forEach(user -> log.info(user.toString()));
		
		assertEquals(2, list.size());
	}

	@Disabled @Test
	public void test2() {
		// Update
		this.userService.updateUser(new UserVO("dooly", "김둘리", "여", "부산"));
		UserVO user = this.userService.getUser("dooly");
		log.info(user.toString());
		assertEquals("부산", user.getCity());
	}
	
	@Disabled @Test
	public void test3() {
		this.userService.deleteUser("dooly");
		List<UserVO> list = this.userService.getUserList();
		list.forEach(user -> log.info(user.toString()));
		assertEquals(1, list.size());
	}
}
