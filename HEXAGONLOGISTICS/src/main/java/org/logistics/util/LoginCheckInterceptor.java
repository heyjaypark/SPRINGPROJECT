package org.logistics.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
@SessionAttributes("authUser")
public class LoginCheckInterceptor implements HandlerInterceptor {
	
	   @Override
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
	            throws Exception {
	        // 세션에서 authUser 확인
	        Object authUser = request.getSession().getAttribute("authUser");

	        // 로그 확인
	        System.out.println("LoginCheckInterceptor - preHandle: authUser=" + authUser);

	        // 로그인되어 있지 않다면 로그인 페이지로 리다이렉트
	        if (authUser == null) {
	            response.sendRedirect(request.getContextPath() + "/loginForm");
	            return false; // 컨트롤러 메서드 호출 중단
	        }

	        return true; // 컨트롤러 메서드 호출 계속 진행
	    }

	    // 나머지 메서드는 그대로 유지

}
