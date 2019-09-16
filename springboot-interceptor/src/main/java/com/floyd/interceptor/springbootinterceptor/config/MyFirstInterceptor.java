package com.floyd.interceptor.springbootinterceptor.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.lang.Nullable;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.ValidatorFactory;
import java.util.Map;

/**
 * 注释
 *
 * @author floyd
 * @version : MyFirstInterceptor.java, v 0.1 2019/9/12 13:39 By floyd Edit  $$
 */

public class MyFirstInterceptor implements HandlerInterceptor {
	
	private final Logger  logger = LoggerFactory.getLogger (MyFirstInterceptor.class);
	
	
	
	@Override
	public boolean preHandle (
		HttpServletRequest request, HttpServletResponse response, Object handler ) throws Exception {
		
		logger.info ("请求前拦截 ：{}",request.getRequestURL () );
		
		return  true;
	}
	
	@Override
	public void postHandle (
		HttpServletRequest request, HttpServletResponse response, Object handler,
		@Nullable ModelAndView modelAndView ) throws Exception {
		logger.info ("postHandle: {}" ,request.getRequestURL ());
		
	}
	
	@Override
	public void afterCompletion( HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
		logger.info ("after:执行完成");
	}
}
