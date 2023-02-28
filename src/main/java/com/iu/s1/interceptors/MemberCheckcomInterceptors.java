package com.iu.s1.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class MemberCheckcomInterceptors extends HandlerInterceptorAdapter  {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//Controller 진입 전
		//retutn 이 true 라면 다음 Controller로 진행
		//retutn 이 false 라면 다음 Controller로 진행 X
		System.out.println("Controller 진입 전 체크");
		
		response.sendRedirect("./Login");
		
		return true;
	}
	
}

