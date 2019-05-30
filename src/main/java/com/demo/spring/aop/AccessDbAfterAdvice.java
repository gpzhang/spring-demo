package com.demo.spring.aop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author haishen
 * @date 2019/3/29
 */
public class AccessDbAfterAdvice implements AfterReturningAdvice {


    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("AccessDbAdvice访问DB后！");

    }
}
