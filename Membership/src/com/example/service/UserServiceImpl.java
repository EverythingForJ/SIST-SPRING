package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.vo.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Override
	public void insertUser(UserVO user) {
		this.userDao.insert(user);
	}

	@Override
	public List<UserVO> getUserList() {
		return this.userDao.readAll();
	}

	@Override
	public void deleteUser(String id) {
		this.userDao.delete(id);
	}

	@Override
	public UserVO getUser(String id) {
		return this.userDao.read(id);
	}

	@Override
	public void updateUser(UserVO user) {
		this.userDao.update(user);
	}

}
