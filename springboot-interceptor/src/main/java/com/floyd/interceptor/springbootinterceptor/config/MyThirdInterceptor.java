package com.floyd.interceptor.springbootinterceptor.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 注释
 *
 * @author floyd
 * @version : MyFirstInterceptor.java, v 0.1 2019/9/12 13:39 By floyd Edit  $$
 */

public class MyThirdInterceptor implements HandlerInterceptor {
	
	private final Logger  logger = LoggerFactory.getLogger (MyThirdInterceptor.class);
	
	@Override
	public boolean preHandle (
		HttpServletRequest request, HttpServletResponse response, Object handler ) throws Exception {
		
		logger.info ("MyThirdInterceptor -->请求前拦截 ：{}",request.getRequestURL () );
		
		return  true;
	}
	
	@Override
	public void postHandle (
		HttpServletRequest request, HttpServletResponse response, Object handler,
		@Nullable ModelAndView modelAndView ) throws Exception {
		
		logger.info ("MyThirdInterceptor --> postHandle: {}" ,request.getRequestURL ());
		
	}
	
	@Override
	public void afterCompletion( HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
		logger.info ("MyThirdInterceptor --> after:执行完成");
	}
}
