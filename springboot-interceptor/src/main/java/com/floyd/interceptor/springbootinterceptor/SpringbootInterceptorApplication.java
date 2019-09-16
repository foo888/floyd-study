package com.floyd.interceptor.springbootinterceptor;

import com.floyd.interceptor.springbootinterceptor.config.MyFirstInterceptor;
import com.floyd.interceptor.springbootinterceptor.config.MySecondInterceptor;
import com.floyd.interceptor.springbootinterceptor.config.MyThirdInterceptor;
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
	
	@Bean
	public MySecondInterceptor  secondInterceptor (){
		return new MySecondInterceptor ();
	}
	
	@Bean
	public MyThirdInterceptor thirdInterceptor () {
		return new MyThirdInterceptor ();
	}
}
