package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserRolesDao;
import com.example.vo.UserRolesVO;

@Service
public class UserRolesService {
	@Autowired
	private UserRolesDao userRolesDao;
	
	public void insertRoles(UserRolesVO userRolesVo) {
		this.userRolesDao.insert(userRolesVo);
	}
	
	public List<UserRolesVO> selectRoles(String userid) {
		return this.userRolesDao.select(userid);
	}
}
