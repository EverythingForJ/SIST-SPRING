package com.example.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LoginExceptionAdvice {

	private static final Logger logger = 
			LoggerFactory.getLogger(LoginExceptionAdvice.class);
	
	@ExceptionHandler(Exception.class)
	public String except(Exception ex, Model model) {
		logger.error("Exception ........ " + ex.getMessage());
		model.addAttribute("exception", ex.getMessage());
		logger.error(model.toString());
		return "membership/error";     //WEB-INF/views/membership/error.jsp
	}
}
