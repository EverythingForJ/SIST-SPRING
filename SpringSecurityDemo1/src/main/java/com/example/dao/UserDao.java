package com.example.dao;

import org.springframework.stereotype.Repository;

import com.example.vo.UserVO;

import lombok.Setter;

@Repository
@Setter
public class UserDao {
	private String username;
	private String password;
	
	public UserVO getUsersByID(String username) {
		return new UserVO(this.username, this.password);
	}
}
