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

//1. Presentation Layer --> Service Layer
@ExtendWith(SpringExtension.class)
//@ContextConfiguration(locations="classpath:beans.xml")
@ContextConfiguration(classes = {ApplicationConfig.class})
class MembershipTest {
	@Autowired
	UserService userService;
	
	@Disabled @Test
	public void test() {
		// assertNotNull(this.userService);
		UserVO userVO = this.userService.getUser("jimin");
		System.out.println(userVO);
		assertEquals("한지민", userVO.getName());
	}
	
	@Disabled @Test
	public void test1() {
		// insert 및 selectAll
		UserVO userVO = new UserVO("dooly", "둘리", "남", "경기");
		this.userService.insertUser(userVO);
		
		List<UserVO> list = this.userService.getUserList();
		for(UserVO user : list) {
			System.out.println(user);
		}
		assertEquals(2, list.size());
		
	}
	
	@Disabled @Test
	public void test2() {
		//사용자 정보 수정 test
		this.userService.updateUser(new UserVO("dooly", "김둘리", "여", "부산"));
		UserVO user = this.userService.getUser("dooly");
		System.out.println(user);
		assertEquals("부산", user.getCity());
	}
	
	@Test
	public void test3() {
		//사용자 정보 삭제 test
		this.userService.deleteUser("dooly");
		
		// 모든 user 가져오기
//		List<UserVO> list = this.userService.getUserList();
//		for(int i=0; i<list.size(); i++) {
//			System.out.println(list.get(i));
//		}

//		List<UserVO> list = this.userService.getUserList();
//		for(UserVO user : list) {
//			System.out.println(user);
//		}
		
		List<UserVO> list = this.userService.getUserList();
		list.forEach(user -> System.out.println(user));
		assertEquals(1, this.userService.getUserList().size());
	}

}
