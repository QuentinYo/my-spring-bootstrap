package me.yukuixing.springwebdemo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * LogExecutionTimeAspect
 *
 * @author: yukuixing
 * @since : 2020-01-07 23:11
 *
 * https://www.baeldung.com/spring-aop-annotation
 */
@Slf4j
@Aspect
@Component
public class LogExecutionTimeAspect {

    @Around("@annotation(LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long cost = System.currentTimeMillis() - start;
        log.debug("method[{}] cost {}ms", joinPoint.getSignature(), cost);
        return proceed;
    }
}
