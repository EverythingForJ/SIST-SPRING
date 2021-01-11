package com.example.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.vo.UserRolesVO;

@Repository
public class UserRolesDao {
	@Autowired
	private SqlSession sqlSession;
	
	public void insert(UserRolesVO userRolesVo) {
		this.sqlSession.insert("UserRoles.insert", userRolesVo);
	}
	
	public List<UserRolesVO> select(String userid) {
		List<UserRolesVO> list = this.sqlSession.selectList("UserRoles.select", userid);
		return list;
	}
}
