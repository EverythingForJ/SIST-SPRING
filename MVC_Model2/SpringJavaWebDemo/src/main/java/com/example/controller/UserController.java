package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.service.UserService;
import com.example.vo.UserVO;

import lombok.extern.java.Log;

@Controller
@Log
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(UserVO userVO) {
		log.info(userVO.toString());
		this.userService.create(userVO);
		return "redirect:/";
	}
}
