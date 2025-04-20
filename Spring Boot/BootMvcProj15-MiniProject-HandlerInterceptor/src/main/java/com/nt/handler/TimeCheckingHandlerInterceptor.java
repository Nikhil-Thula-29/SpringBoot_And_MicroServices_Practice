package com.nt.handler;

import java.time.LocalDateTime;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TimeCheckingHandlerInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//get system date and time
		LocalDateTime ldt=LocalDateTime.now();
		if(!request.getServletPath().equalsIgnoreCase("/")) {
		int time=ldt.getHour();
		if(time<12||time>5) {
			RequestDispatcher rd=request.getRequestDispatcher("/timeout.jsp");
			rd.forward(request, response);
			return false;
		}
	}
		return true;
	}
	
}
