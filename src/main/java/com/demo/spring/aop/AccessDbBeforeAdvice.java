package com.demo.spring.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author haishen
 * @date 2019/3/29
 */
public class AccessDbBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("AccessDbAdvice访问DB前！");

    }

}
