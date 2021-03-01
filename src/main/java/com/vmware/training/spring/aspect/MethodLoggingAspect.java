package com.vmware.training.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
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

    @Around("executeMethodLogging()")
    public Object logMethodDetails(ProceedingJoinPoint joinPoint ) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object returnValue = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        LOGGER.info("After Executing Method: " + joinPoint.getSignature().toString());
        LOGGER.info("ReturnValue : " + returnValue);
        LOGGER.info("Time taken in millis : " + (endTime - startTime));

        return returnValue;

    }

}
