package com.example.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Scanner;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.config.RootConfig;
import com.example.vo.UserVO;

import lombok.extern.java.Log;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log
class DaoTest {
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private SqlSession sqlSession;
	
	@Disabled @Test
	void test() {
		assertNotNull(this.dataSource);
		log.info(this.dataSource.toString());
	}

	@Disabled @Test
	void test1() {
		assertNotNull(this.sqlSession);
		log.info(this.sqlSession.toString());
	}

	@Disabled @Test
	void test2() {
		List<UserVO> list = this.sqlSession.selectList("Users.selectAll");
		list.forEach(user -> log.info(user.toString()));
	}
	
	@Disabled @Test
	void test3() {
		UserVO userVO = new UserVO("jun","12345","김준민", 30, "남성");
		this.sqlSession.insert("Users.insert", userVO);
		List<UserVO> list = this.sqlSession.selectList("Users.selectAll");
		list.forEach(user -> log.info(user.toString()));
	}
	
	@Disabled @Test
	void test4() {
		Scanner scan = new Scanner(System.in);
		System.out.println("검색할 유저의 아이디 : ");
		String userid = scan.next().trim();
		UserVO userVO = (UserVO)this.sqlSession.selectOne("Users.selectOne", userid);
		log.info(userVO.toString());
	}
	
	@Disabled @Test
	public void test5() {
		UserVO userVO = new UserVO("jimin", "7878", "한주민", 5, "남성");
		this.sqlSession.update("Users.update", userVO);
	}
	
	@Test
	public void test6() {
		Scanner scan = new Scanner(System.in);
		System.out.println("삭제할 아이디 : ");
		String userid = scan.next().trim();
		
		this.sqlSession.delete("Users.delete", userid);
	}
}
