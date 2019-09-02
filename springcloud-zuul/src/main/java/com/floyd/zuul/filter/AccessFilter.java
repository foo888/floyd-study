package com.floyd.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * 注释
 *
 * @author floyd
 * @version : AccessFilter.java, v 0.1 2019/9/2 13:41 By floyd Edit  $$
 */
public class AccessFilter extends ZuulFilter {
	
	private final Logger logger = LoggerFactory.getLogger (AccessFilter.class);
	
	/**
	 * 过滤器的类型
	 * @return
	 */
	@Override
	public String filterType () {
		
		return "pre";
	}
	
	/**
	 * 多个过滤器的执行顺序
	 * @return
	 */
	@Override
	public int filterOrder () {
		
		return 0;
	}
	
	/**
	 * 是否要被执行
	 * @return
	 */
	@Override
	public boolean shouldFilter () {
		
		return true;
	}
	
	@Override
	public Object run () throws ZuulException {
		
		RequestContext  ctx = RequestContext.getCurrentContext ();
		HttpServletRequest request = ctx.getRequest ();
		
		logger.info ("请求方法{},URL{}",request.getMethod (),request.getRequestURL ().toString ());
		
		Object accessToken = request.getParameter ("accessToken");
		
		if ( accessToken == null ) {
			logger.error ("access  Token  is  empty");
			ctx.setSendZuulResponse (false);
			ctx.setResponseStatusCode (401);
			return  null;
		}
		logger.info (" access  Token ok");
		return null;
	}
}
