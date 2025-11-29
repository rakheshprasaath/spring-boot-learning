package com.rakhesh.jobApp.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Performance {

    public static final Logger LOGGER= LoggerFactory.getLogger(Performance.class);

    @Around("execution (* com.rakhesh.jobApp.service.JobService.*(..))")
    public Object logPerformance(ProceedingJoinPoint pjp) throws Throwable {
        long startTime=System.currentTimeMillis();
        Object obj=pjp.proceed();
        long endTime=System.currentTimeMillis();
        LOGGER.info("Execution time for {}: {}",pjp.getSignature().getName(), endTime-startTime);
        return obj;
    }


}
