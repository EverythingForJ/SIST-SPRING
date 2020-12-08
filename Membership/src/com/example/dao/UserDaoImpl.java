package com.example.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import com.example.vo.UserVO;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Override
	public void insert(UserVO user) {
		Reader rd = null;
		SqlSession session = null;
		UserVO userVO = null;
		try {
			rd = Resources.getResourceAsReader("mybatis-config.xml");
			session = new SqlSessionFactoryBuilder().build(rd).openSession();
			session.insert("insert", user);
			session.commit();
			System.out.println("등록된 Record UserId=" + user.getUserId() + " Name=" + user.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<UserVO> readAll() {
		Reader rd = null;
		SqlSession session = null;
		List<UserVO> userList = null;
		try {
			rd = Resources.getResourceAsReader("mybatis-config.xml");
			session = new SqlSessionFactoryBuilder().build(rd).openSession();
			userList = session.selectList("selectAll");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public void update(UserVO user) {
		Reader rd = null;
		SqlSession session = null;
		UserVO userVO = null;
		try {
			rd = Resources.getResourceAsReader("mybatis-config.xml");
			session = new SqlSessionFactoryBuilder().build(rd).openSession();
			session.update("update", user);
			session.commit();
			System.out.println("갱신된 Record with ID = " + user.getUserId());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String id) {
		Reader rd = null;
		SqlSession session = null;
		UserVO userVO = null;
		try {
			rd = Resources.getResourceAsReader("mybatis-config.xml");
			session = new SqlSessionFactoryBuilder().build(rd).openSession();
			session.delete("delete", id);
			session.commit();
			System.out.println("삭제된 Record with ID = " + id);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public UserVO read(String id) {
		Reader rd = null;
		SqlSession session = null;
		UserVO userVO = null;
		try {
			rd = Resources.getResourceAsReader("mybatis-config.xml");
			session = new SqlSessionFactoryBuilder().build(rd).openSession();
			userVO = (UserVO) session.selectOne("select", id);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userVO;
	}

}
