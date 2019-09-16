package com.floyd.interceptor.springbootinterceptor.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 统一异常处理
 *
 * @author floyd
 * @version : ExecptionHandler.java, v 0.1 2019/8/23 17:13 By floyd Edit  $$
 */

@ControllerAdvice
public class ExecptionHandler {
	
	private Logger logger = LoggerFactory.getLogger (ExecptionHandler.class);
	
	
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	String defaultErrorHandler( HttpServletRequest req, Exception e) throws Exception {
		logger.error("{}", e.getMessage ());
		return e.getMessage();
	}
	
	
}
