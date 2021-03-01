package com.vmware.training.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MethodLoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodLoggingAspect.class);

    @Pointcut("@annotation(MethodLogger)")
    public void executeMethodLogging(){
    }

    @Before("executeMethodLogging()")
    public void logMethodDetails(JoinPoint joinPoint){
        LOGGER.info("Before Executing Method: " + joinPoint.getSignature().toString());
    }

}
