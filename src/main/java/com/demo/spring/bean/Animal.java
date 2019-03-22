package com.demo.spring.bean;

import org.springframework.stereotype.Component;

/**
 * @author haishen
 * @date 2018/8/2
 * 注解扫描注入bean
 */
@Component
public class Animal {

    private String name;

    public Animal() {
        System.out.println("实例化Animal");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void say() {
        System.out.println("Hello " + name);
    }
}
