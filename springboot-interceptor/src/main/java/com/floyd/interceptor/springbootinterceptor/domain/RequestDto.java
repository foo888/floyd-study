package com.floyd.interceptor.springbootinterceptor.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 注释
 *
 * @author floyd
 * @version : RequestDto.java, v 0.1 2019/8/23 11:19 By floyd Edit  $$
 */

@Data
public class RequestDto implements Serializable {
	
	private static final long serialVersionUID = 8049172738251461758L;
	
	@NotNull(message = "手机号不能为空")
	@Length(min = 11,max = 11,message = "手机号格式错误")
	private String telnum;
	
	@NotNull(message = "归属地不能为空")
	@Length(min = 3,max = 3,message = "归属地数据格式错误")
	private String region;
	
	private String billType;
	
	private String stauts;
	
}
