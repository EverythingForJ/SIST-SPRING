package com.example.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.service.UserService;
import com.example.vo.UserVO;

import lombok.extern.java.Log;

@Controller
@Log
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "index"; // WEB-INF/views/index.jsp
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(UserVO userVO) {
		//log.info(userVO.toString());
		this.userService.create(userVO);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/select/{userid}", method=RequestMethod.GET)
	public void select(@PathVariable String userid) {
		// log.info("userid = "+userid);
		UserVO userVO = this.userService.read(userid);
		log.info("찾은 유저 = "+userVO.toString());
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public String login() {
		return "login"; //WEB-INF/wiews/login.jsp
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public ModelAndView login1(@RequestParam("userid") String userid,
							@RequestParam("passwd") String passwd) {
		//log.info("userid = "+userid);
		//log.info("passwd = "+passwd);
		int result = this.userService.login(userid, passwd);
		// log.info("result = " + result);
		// -1 : 그런 계정 없다. 0 : 비밀번호 불일치 1 : 모두 성공
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", result);
		
		// login에 성공하면 userid를 가지고 해당 유저의 정보를 가져오자.
		UserVO userVO = null;
		if(result==1) {
			userVO = this.userService.read(userid);
			mav.addObject("userInfo", userVO);
		}
		
		mav.setViewName("loginresult"); // WEB-INF/views/
		return mav;
	}
	
	@RequestMapping(value="/idcheck/{userid}", method = RequestMethod.POST)
	public @ResponseBody Map idcheck(@PathVariable String userid) {
		UserVO userVO = this.userService.read(userid);
		//해당 userid를 찾으면 null이 아니고, 못찾으면 null이다. 
		//해당 userid를 찾으면, 이 아이디는 사용할 수 없고,
		//해당 userid를 못찾으면 이 아이디는 사용할 수 있다. 
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "success");
		if(userVO == null) map.put("result", true);  //사용할 수 있음.
		else map.put("result", false);   //사용할 수 없음.
		return map;
	}
}
