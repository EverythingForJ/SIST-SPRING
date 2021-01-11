package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.vo.UserVO;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	public void insertUser(UserVO userVo) {
		this.userDao.insert(userVo);
	}
	
	public UserVO getUserByID(String userid) {
		return this.userDao.select(userid);
	}
}
