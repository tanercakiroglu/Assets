package com.chrental.aspect.logger;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class LogManager {

       @Pointcut("execution(* com.chrental.service..*(..))")
       public void auditLog() {}

       @Pointcut("execution(* com.chrental.service..*(..))")
       public void performanceLog(){}

}