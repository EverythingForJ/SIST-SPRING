package com.example.biz;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@RequestMapping(value = "/demo", method = RequestMethod.GET)
	public ModelAndView demo() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("pname", "Notebook");
		mav.addObject("pprice", 2500000);
		mav.addObject("pmaker", "Samsung");
		mav.setViewName("/mydemo"); // WEB-INF/views/mydemo.jsp
		return mav;
	}

	@RequestMapping("/view")
	public String view(Model model) {
		model.addAttribute("currentDate", new java.util.Date());
		return "view"; // WEB-INF/views/view.jsp
	}

	@RequestMapping("/user")
	public String user(Model model) {
		model.addAttribute("username", "한지민");
		model.addAttribute("userage", 24);
		model.addAttribute("job", "Developer");
		return "user"; // WEB-INF/views/user.jsp
	}

	@RequestMapping("/fruits")
	public String fruits(Model model) {
		String[] array = { "Apple", "Mango", "Lemon", "Grape" };
		model.addAttribute("fruits", array);
		return "fruits"; // WEB-INF/views/fruits.jsp
	}
}
