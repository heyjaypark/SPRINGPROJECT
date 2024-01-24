package org.logistics.controller;

import java.util.HashMap;
import java.util.Map;

import org.logistics.exception.DuplicateIdException;
import org.logistics.exception.LoginFailException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;

@ControllerAdvice

@RequestMapping("/in/*")
@AllArgsConstructor
public class ExceptionController {
	
	@ExceptionHandler(DuplicateIdException.class)
    public String handleDuplicateIdException(DuplicateIdException e, Model model) {
        // 여기에서 예외 처리 로직 및 오류 페이지로 이동하는 로직을 추가
		
		Map<String, Boolean> errors = new HashMap<>();
		errors.put("duplicateId", Boolean.TRUE);
		 model.addAttribute("errors", errors);
		
        return "/in/joinForm";
    }
	
	@ExceptionHandler(LoginFailException.class)
    public String handleLoginFailException(LoginFailException e, Model model) {
        // 여기에서 예외 처리 로직 및 오류 페이지로 이동하는 로직을 추가
		
		Map<String, Boolean> errors = new HashMap<>();
		errors.put("id", Boolean.TRUE);
		errors.put("password", Boolean.TRUE);
		
		 model.addAttribute("errors", errors);
		
        return "/in/loginForm";
    }

}
