package com.floyd.interceptor.springbootinterceptor.config;

import com.floyd.interceptor.springbootinterceptor.domain.RequestUser;
import com.floyd.interceptor.springbootinterceptor.util.VailException;
import com.floyd.interceptor.springbootinterceptor.util.VailUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.lang.Nullable;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 自定义拦截器一
 *
 * @author floyd
 * @version : MyFirstInterceptor.java, v 0.1 2019/9/12 13:39 By floyd Edit  $$
 */

public class MyFirstInterceptor implements HandlerInterceptor {
	
	private final Logger  logger = LoggerFactory.getLogger (MyFirstInterceptor.class);
	
	@Autowired
	private VailUtils vail;
	
	@Override
	public boolean preHandle (
		HttpServletRequest request, HttpServletResponse response, Object handler ) throws Exception {
		
		logger.info ("请求前拦截 ：{}",request.getRequestURL () );
		
		Map map =  request.getParameterMap ();
		
		HandlerMethod method = ( HandlerMethod ) handler;
		MethodParameter[] params = method.getMethodParameters ();
		if (params ==  null || params.length == 0 ) {
			return  true;
		}
		MethodParameter parameter = params[0];
		Class reqClass = parameter.getParameterType ();
		
		if (reqClass.newInstance () instanceof  RequestUser) {
			//Map 转化成 bean
			RequestUser ru =  vail.mapToBean (map, RequestUser.class);
			//验证
			String msg = vail.validata (ru);
			if (StringUtils.isNotEmpty(msg)) {
				logger.error ("验证结果：{}",msg);
				//抛出自定义异常结果
				throw  new VailException (msg);
			}
		}
		
		
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
