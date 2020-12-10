package com.example.biz;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.vo.UserVO;

import lombok.extern.java.Log;

@Controller
@Log
public class RequestController {

	// @RequestMapping(value = {"/confirm"}, method = {RequestMethod.GET})
	public String confirm(HttpServletRequest request, Model model) {
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String[] hobbies = request.getParameterValues("hobby");

		model.addAttribute("userid", userid);
		model.addAttribute("passwd", passwd);
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		model.addAttribute("gender", gender);
		model.addAttribute("hobbies", hobbies);

		return "confirm"; // WEB-INF/views/confirm.jsp
	}

	// @RequestMapping(value = {"/confirm"}, method = {RequestMethod.GET})
	public String confirm1(@RequestParam("userid") String userid, @RequestParam("passwd") String passwd,
			@RequestParam("name") String name, @RequestParam("age") int age, @RequestParam("gender") String gender,
			@RequestParam("hobby") String[] hobbies, Model model) {

		model.addAttribute("userid", userid);
		model.addAttribute("passwd", passwd);
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		model.addAttribute("gender", gender);
		model.addAttribute("hobbies", hobbies);

		return "confirm"; // WEB-INF/views/confirm.jsp
	}

	// @RequestMapping(value = {"/confirm"}, method = {RequestMethod.GET})
	public String confirm2(@RequestParam("userid") String userid, @RequestParam("passwd") String passwd,
			@RequestParam("name") String name, @RequestParam("age") int age, @RequestParam("gender") String gender,
			@RequestParam("hobby") String[] hobbies, Model model) {

		UserVO userVO = new UserVO();
		userVO.setUserid(userid);
		userVO.setPasswd(passwd);
		userVO.setName(name);
		userVO.setAge(age);
		userVO.setGender(gender);
		// userVO.setHobbies(hobbies);
		model.addAttribute("userVO", userVO);

		return "confirm2"; // WEB-INF/views/confirm2.jsp
	}

	// @RequestMapping(value = {"/confirm"}, method = {RequestMethod.GET})
	public String confirm3(UserVO userVO) {
		log.info(userVO.toString());
		return "confirm3"; // WEB-INF/views/confirm3.jsp
	}

	// @RequestMapping(
	// value="/confirm/{userid}/{passwd}/{name}/{age}/{gender}/{hobby}",
	// method=RequestMethod.GET)
	public String confirm4(@PathVariable String userid, @PathVariable String passwd, @PathVariable String name,
			@PathVariable int age, @PathVariable String gender, @PathVariable String[] hobby, Model model) {
		UserVO userVO = new UserVO(userid, passwd, name, age, gender, hobby);
		model.addAttribute("userInfo", userVO);
		log.info(userVO.toString());
		return "confirm4"; // WEB-INF/views/confirm4.jsp
	}

	@RequestMapping(value = { "/confirm" }, method = { RequestMethod.POST})
	public String confirm5(@ModelAttribute("u") UserVO userVO) {

		return "confirm5"; // WEB-INF/views/confirm5.jsp
	}
}
