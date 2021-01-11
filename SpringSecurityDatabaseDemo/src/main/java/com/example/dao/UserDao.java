package com.example.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.vo.UserVO;

import lombok.Setter;

@Repository
@Setter
public class UserDao {
	@Autowired
	private SqlSession sqlSession;
	
	public void insert(UserVO userVo) {
		this.sqlSession.insert("Users.insert", userVo);
	}
	public UserVO select(String userid) {
		UserVO userVo = this.sqlSession.selectOne("Users.select", userid);
		return userVo;
	}
}
