package com.example.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.vo.UserVO;

import lombok.extern.java.Log;

@Repository("userDao")
@Log
public class UserDaoImpl implements UserDao {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertUser(UserVO userVO) {
		log.info("추가되는 유저 정보 = "+userVO.toString());
		this.sqlSession.insert("insert", userVO);
	}

	@Override
	public UserVO selectUser(String userid) {
		return (UserVO)this.sqlSession.selectOne("Users.selectOne", userid);
	}

	@Override
	public List<UserVO> selectAllUsers() {
		return this.sqlSession.selectList("Users.selectAll");
	}

	@Override
	public void updateUser(UserVO userVO) {
		this.sqlSession.update("Users.update", userVO);
	}

	@Override
	public void deleteUser(String userid) {
		this.sqlSession.delete("Users.delete", userid);
	}

	@Override
	public int loginUser(String userid, String passwd) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userid", userid); // INPUT Parameter
		map.put("passwd", passwd); // INPUT Parameter
		this.sqlSession.selectList("Users.login", map);
		// log.info("result = " + map.get("result"));
		return (Integer)map.get("result");
	}
	
}
