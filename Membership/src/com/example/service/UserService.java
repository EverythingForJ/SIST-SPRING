package com.example.service;

import java.util.List;

import com.example.vo.UserVO;

public interface UserService {
	void insertUser(UserVO user);
	List<UserVO> getUserList();
	void deleteUser(String id);
	UserVO getUser(String id);
	void updateUser(UserVO user);
}
