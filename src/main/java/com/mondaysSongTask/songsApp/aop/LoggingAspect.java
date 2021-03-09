package com.mondaysSongTask.songsApp.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableAspectJAutoProxy
@Slf4j
public class LoggingAspect {

    @Pointcut("execution(* com.mondaysSongTask.songsApp..*(..))")
    private void anyPublicMethod() {
    }

    @Before("anyPublicMethod()")
    public void beforeAnyPublicMethod(JoinPoint joinPoint) {
        log.info(" :: Before :: " + joinPoint.toShortString());
    }

    @After("anyPublicMethod()")
    public void afterAnyPublicMethod(JoinPoint joinPoint) {
        log.info(" :: After :: " + joinPoint.toShortString());
    }

}
