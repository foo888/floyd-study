package com.floyd.interceptor.springbootinterceptor.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * 注释
 *
 * @author floyd
 * @version : MyMvc.java, v 0.1 2019/9/12 13:45 By floyd Edit  $$
 */
@Configuration
//此注解相当于spring mvc  的web.xml 配置文件

public class MyMvc implements WebMvcConfigurer{
	
	@Autowired
	private MyFirstInterceptor  firstInterceptor;
	
	@Override
	public void  addInterceptors ( InterceptorRegistry registry) {
		
		
		List<String> staticResource = new ArrayList <> ();
		staticResource.add ("/js/**");
		
		registry.addInterceptor (firstInterceptor).addPathPatterns ("/**").excludePathPatterns (staticResource);
		registry.addInterceptor (new MyThirdInterceptor ()).addPathPatterns ("/**");
		registry.addInterceptor (new MySecondInterceptor()).addPathPatterns ("/**");
		
		
	}

	
}
