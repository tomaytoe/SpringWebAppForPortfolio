package com.portfolio.cv.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    //Setup logger
    private Logger logger = Logger.getLogger(getClass().getName());

    //Setup pointcut declaration
    @Pointcut("execution(* com.portfolio.cv.controller.*.*(..))")
    private void forControllerPackage(){

    }

    @Pointcut("execution(* com.portfolio.cv.dao.*.*(..))")
    private void forDaoPackage(){

    }

    @Pointcut("execution(* com.portfolio.cv.service.*.*(..))")
    private void forServicePackage(){

    }

    @Pointcut("forControllerPackage() || forDaoPackage() || forServicePackage()")
    private void forAppFlow(){

    }

    //add @Before advice
    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint){
        String theMethod = theJoinPoint.getSignature().toLongString();
        logger.info("====> In @Before: calling method: " + theMethod);
    }
    //add @AfterReturning advice
}
