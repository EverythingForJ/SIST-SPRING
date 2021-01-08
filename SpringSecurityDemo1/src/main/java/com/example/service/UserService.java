package com.example.service;

import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.vo.UserVO;

import lombok.Setter;

@Service
@Setter
public class UserService {
	private UserDao userDao;

	public UserVO getUserByID(String username) {
		return this.userDao.getUsersByID(username);
	}
}
