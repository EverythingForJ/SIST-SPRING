package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDaoImpl;
import com.example.vo.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDaoImpl userDao;

	@Override
	public void create(UserVO userVO) {
		this.userDao.insertUser(userVO);
	}

	@Override
	public UserVO read(String userid) {
		return this.userDao.selectUser(userid);
	}

	@Override
	public List<UserVO> readAll() {
		return this.userDao.selectAllUsers();
	}

	@Override
	public void update(UserVO userVO) {
		this.userDao.updateUser(userVO);
	}

	@Override
	public void delete(String userid) {
		this.userDao.deleteUser(userid);
	}

	@Override
	public int login(String userid, String passwd) {
		return this.userDao.loginUser(userid, passwd);
	}
	
	
}
