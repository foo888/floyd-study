package com.floyd.interceptor.springbootinterceptor;

import com.floyd.interceptor.springbootinterceptor.config.MyFirstInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootInterceptorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootInterceptorApplication.class, args);
	}
	
	@Bean
	public MyFirstInterceptor myFirstInterceptor (){
		return  new MyFirstInterceptor ();
	}
}
