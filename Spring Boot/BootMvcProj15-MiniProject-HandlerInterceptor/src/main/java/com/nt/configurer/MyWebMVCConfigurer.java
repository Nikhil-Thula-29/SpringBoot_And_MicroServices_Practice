package com.nt.configurer;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.nt.handler.TimeCheckingHandlerInterceptor;

@Component
public class MyWebMVCConfigurer implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		System.out.println("MyWebMVCConfigurer.addInterceptors()");
		registry.addInterceptor(new TimeCheckingHandlerInterceptor());
	}
}
