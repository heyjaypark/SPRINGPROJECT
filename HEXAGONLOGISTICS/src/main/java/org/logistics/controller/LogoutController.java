package org.logistics.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/in/*")
@AllArgsConstructor
public class LogoutController {
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession(false);
        if (session != null) {
            // 세션을 무효화
        	 Object authUser = session.getAttribute("authUser");
             System.out.println("authUser 세션 값: " + authUser);
             
            session.invalidate();
            System.out.println("세션을 무효화했습니다.");
            
            System.out.println("authUser 무효화후 세션 값: " + authUser);
            return "redirect:/";
        }
        return null;
		
	}

}
