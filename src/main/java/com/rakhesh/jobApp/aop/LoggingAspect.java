package com.rakhesh.jobApp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    public static final Logger LOGGER=LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution (* com.rakhesh.jobApp.service.JobService.*(..))")
    public void beforeMethod(JoinPoint jp) {
        LOGGER.info("Method Called "+jp.getSignature().getName());
    }


    @After("execution (* com.rakhesh.jobApp.service.JobService.*(..))")
    public void afterMethod(JoinPoint jp){
        LOGGER.info("Method Executed: {}", jp.getSignature().getName());
    }

    @AfterThrowing("execution (* com.rakhesh.jobApp.service.JobService.*(..))")
    public void afterMethodException(JoinPoint jp){
        LOGGER.info("Method execution got some issue: {}", jp.getSignature().getName());
    }

    @AfterReturning("execution (* com.rakhesh.jobApp.service.JobService.*(..))")
    public void afterMethodSuccess(JoinPoint jp){
        LOGGER.info("Method Executed successfully: {}", jp.getSignature().getName());
    }

}
