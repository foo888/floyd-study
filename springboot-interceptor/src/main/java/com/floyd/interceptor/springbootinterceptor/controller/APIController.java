package com.floyd.interceptor.springbootinterceptor.controller;

import com.alibaba.fastjson.JSON;
import com.floyd.interceptor.springbootinterceptor.domain.RequestDto;
import com.floyd.interceptor.springbootinterceptor.domain.RequestUser;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;

/**
 * api 控制器示例
 *
 * @author floyd
 * @version : APIController.java, v 0.1 2019/9/16 14:35 By floyd Edit  $$
 */

@RequestMapping ("/api")
@RestController
public class APIController {

	
	@GetMapping (value = "/users")
	String  test (RequestUser requestUser){
		return JSON.toJSONString (requestUser);
	}
	
	@GetMapping (value = "/qry")
	String  test ( @Valid RequestDto  requestDto, BindingResult err) {
		
		if ( err.hasErrors () ) {
			HashMap<String,String> errMap = new HashMap <> ();
			err.getAllErrors ().stream ().forEach (
				er ->{
					FieldError fieldError = (FieldError)er;
					errMap.put (fieldError.getField (),fieldError.getDefaultMessage ());
				}
			);
			return JSON.toJSONString (errMap);
		}
		
		return JSON.toJSONString (requestDto);
	}
}
