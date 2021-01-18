package com.vmware.training.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
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

    @AfterReturning(value = "executeMethodLogging()", returning = "returnValue")
    public void logMethodDetails(JoinPoint joinPoint, Object returnValue ){
        LOGGER.info("After Executing Method: " + joinPoint.getSignature().toString());
        LOGGER.info("ReturnValue : " + returnValue);

    }

}
