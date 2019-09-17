package com.floyd.interceptor.springbootinterceptor.util;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DoubleConverter;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 验证字段
 *
 * @author floyd
 * @version : VailUtils.java, v 0.1 2019/9/16 15:35 By floyd Edit  $$
 */
public class VailUtils {
	
	
	private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	
	public static <T> List<String> validateAll( T o) {
		List<String> errorList = new ArrayList<String> ();
		Set<ConstraintViolation<T>> violations = factory.getValidator().validate(o);
		if (!CollectionUtils.isEmpty (violations)) {
			violations.forEach (tConstraintViolation -> {
				errorList.add(tConstraintViolation.getMessage());
			});
			
		}
		return errorList;
	}
	
	
	public String validata(Object param) throws RuntimeException {
		String errorMessage = null;
		try {
			List<String> errorList = validateAll(param);
			Assert.isTrue(CollectionUtils.isEmpty(errorList), errorList.toString());
		} catch (Exception e) {
			errorMessage = e.getMessage();
		}
		return errorMessage;
	}
	
	public <T> T mapToBean( Map<String,String> map, Class<T> cla) throws Exception {
		T  bean = null;
		try {
			bean = cla.newInstance ();
			ConvertUtils.register(new DoubleConverter (null), Double.class);
			ConvertUtils.register(new IntegerConverter (null), Integer.class);
			ConvertUtils.register(new DateConverter (null), java.util.Date.class);
			//此方法会自动给 Integer  Double 为 null 的字段赋值，因此需要ConvertUtils.register处理
			BeanUtils.populate(bean, map);
		} catch ( Exception e ){
			e.printStackTrace ();
		}
		
		return bean;
	}
	
	/*public static <T> void  validate(T o) throws IllegalArgumentException {
		Set<ConstraintViolation<T>> violationSet =  factory.getValidator ().validate (o);
		if (!CollectionUtils.isEmpty (violationSet)) {
			ConstraintViolation<T> violation = violationSet.iterator().next();
			throw new IllegalArgumentException(violation.getMessage());
		}
		
	}*/
}
