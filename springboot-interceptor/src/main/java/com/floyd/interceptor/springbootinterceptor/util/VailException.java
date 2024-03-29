package com.floyd.interceptor.springbootinterceptor.util;

/**
 * 定义异常
 *
 * @author floyd
 * @version : VailException.java, v 0.1 2019/9/16 17:20 By floyd Edit  $$
 */
public class VailException extends RuntimeException {
	
	
	public VailException ( String message ) {
		super (message);
	}
	
	/**
	 * 构造方法
	 */
	public VailException ( String message, Throwable cause ) {
		super (message, cause);
	}
	
}
