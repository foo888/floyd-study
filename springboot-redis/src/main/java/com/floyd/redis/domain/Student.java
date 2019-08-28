package com.floyd.redis.domain;

import lombok.Data;

/**
 * 注释
 *
 * @author floyd
 * @version : Student.java, v 0.1 2019/8/28 15:26 By floyd Edit  $$
 */
@Data
public class Student {
	
	private Integer id;
	
	private String name;
	
	private Integer age;
	
	private String  descs;
	
	public Student(){}
	
	public Student ( Integer id, String name, Integer age, String descs ) {
		
		this.id = id;
		this.name = name;
		this.age = age;
		this.descs = descs;
	}
}
