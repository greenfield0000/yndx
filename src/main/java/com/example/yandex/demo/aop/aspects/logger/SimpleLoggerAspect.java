package com.example.yandex.demo.aop.aspects.logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Ivanov Roman
 */
@Aspect
@Component
public class SimpleLoggerAspect {

    private final Logger logger = Logger.getLogger(String.valueOf(this.getClass()));

    @Before(value = "execution(* com.example.yandex.demo.service.AopService.*(..))")
    public void before() {
        logger.log(Level.INFO, "Call before");
    }

    @After(value = "execution(* com.example.yandex.demo.service.AopService.*(..))")
    public void after() {
        logger.log(Level.INFO, "Call after");
    }

    @AfterReturning(value = "execution(* com.example.yandex.demo.service.AopService.*(..))")
    public void afterReturning() {
        logger.log(Level.INFO, "Call afterReturning");
    }

    @AfterThrowing(value = "execution(* com.example.yandex.demo.service.AopService.*(..))")
    public void afterThrowing() {
        logger.log(Level.INFO, "Call afterThrowing");
    }

    @Around(value = "execution(* com.example.yandex.demo.service.AopService.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.log(Level.INFO, "Start around");
        final long start = System.currentTimeMillis();
        final Object proceed = joinPoint.proceed();
        final long finish = System.currentTimeMillis() - start;
        logger.log(Level.INFO, String.format("Finish around with %d ms \\n", finish));
        return proceed;
    }

    @After("pointCutLogger()")
    public void pointCutBefore() {
        logger.log(Level.INFO, "call pointCutAfter");
    }

    @Pointcut(value = "@annotation(PointCutLogger)")
    private void pointCutLogger() {}

}
