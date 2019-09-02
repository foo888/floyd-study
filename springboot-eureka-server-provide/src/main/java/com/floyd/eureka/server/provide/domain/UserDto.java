package com.floyd.eureka.server.provide.domain;

import lombok.Data;

import java.util.UUID;

/**
 * 注释
 *
 * @author floyd
 * @version : UserDto.java, v 0.1 2019/9/2 10:05 By floyd Edit  $$
 */

@Data
public class UserDto {
	
	private Integer  userId;
	
	private String   userName;
	
	private Integer  age;
	
	public UserDto (){}
	
	
	public UserDto (String userName,Integer age){
		this.userName = userName;
		this.age = age;
	}
}
