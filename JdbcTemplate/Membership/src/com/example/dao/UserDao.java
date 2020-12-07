package com.example.dao;

import java.util.List;

import com.example.vo.UserVO;

public interface UserDao {
	void insert(UserVO user);
	List<UserVO> readAll();
	void update(UserVO user);
	void delete(String id);
	UserVO read(String id);
}
