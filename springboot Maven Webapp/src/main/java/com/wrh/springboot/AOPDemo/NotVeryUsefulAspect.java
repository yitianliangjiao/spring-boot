package com.wrh.springboot.AOPDemo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
public class NotVeryUsefulAspect {

    @Pointcut("execution(* com.wrh.springboot.AOPDemo.WebDemo.sayhello(..))")
    public void dataAccessOperation() {}
}
