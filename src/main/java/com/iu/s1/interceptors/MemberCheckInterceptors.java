package com.iu.s1.interceptors;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class MemberCheckInterceptors extends HandlerInterceptorAdapter  {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//Controller 진입 전
		//retutn 이 true 라면 다음 Controller로 진행
		//retutn 이 false 라면 다음 Controller로 진행 X
		Object obj = request.getSession().getAttribute("member");
		
		if(obj != null) {
			
			return true;
		}
		
		System.out.println("로그인 안한 경우");
		//1. Foward Jsp
//		request.setAttribute("result", "권한이 없습니다");
//		request.setAttribute("url", "../member/memberLogin");
//		
//		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
//		view.forward(request, response);
		
		System.out.println("member check Interceptor");
		
		//2.Redirect
		response.sendRedirect("../../../../member/memberLogin");
		
		
		return false;
		
	}
	
}
