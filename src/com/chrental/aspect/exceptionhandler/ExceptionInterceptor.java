package com.chrental.aspect.exceptionhandler;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import com.application.exception.BusinessException;
import com.chrental.util.Util;



@Aspect
public class ExceptionInterceptor {

	
	@Around(value = "com.chrental.aspect.exceptionhandler.ExceptionManager.handleExcepiton()" + "&& target(bean) "
			+ "&& @annotation(com.chrental.aspect.exceptionhandler.HandleException)" + "&& @annotation(handleExcpetion)", argNames = "bean,handleExcpetion")
	public Object handleExcpetion(ProceedingJoinPoint joinPoint, Object bean,HandleException handleExcpetion) throws Throwable {
		
		Object ret = null;
		try {
			ret = joinPoint.proceed();
			return ret;
		}catch(BusinessException bex){
			return	Util.constructJSON("fail",bex.getMessage() ,false);
		}catch (Exception ex) {
			ex.printStackTrace();
		    return	Util.constructJSON("fail",ex.getMessage() ,false);
		}
		
	}
}
