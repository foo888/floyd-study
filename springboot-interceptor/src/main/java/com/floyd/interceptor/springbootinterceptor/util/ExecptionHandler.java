package com.floyd.interceptor.springbootinterceptor.util;

import com.alibaba.fastjson.JSON;
import jdk.nashorn.internal.runtime.JSONFunctions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

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
		
		HashMap<String,String> map = new HashMap <> (2);
		if (e instanceof VailException ) {
			VailException  vex = (VailException) e;
			logger.error("{}", vex.getMessage ());
			
			map.put ("code","vailError");
			map.put ("msg",vex.getMessage ());
		}
		//TODO 其他的异常处理
		
		return JSON.toJSONString (map);
	}
	
	
}
