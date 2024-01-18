package org.logistics.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginCheckInterceptor implements HandlerInterceptor {
	
	 @Override
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
	            throws Exception {
	        // 세션에서 authUser 확인
	        Object authUser = request.getSession().getAttribute("authUser");

	        // 로그인되어 있지 않다면 로그인 페이지로 리다이렉트
	        if (authUser == null) {
	            response.sendRedirect(request.getContextPath() + "/login.do");
	            return false; // 컨트롤러 메서드 호출 중단
	        }

	        return true; // 컨트롤러 메서드 호출 계속 진행
	    }

	    @Override
	    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
	            ModelAndView modelAndView) throws Exception {
	        // 컨트롤러 메서드가 실행된 후에 수행할 작업
	    }

	    @Override
	    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
	            throws Exception {
	        // 뷰가 렌더링된 후에 수행할 작업
	    }

}
