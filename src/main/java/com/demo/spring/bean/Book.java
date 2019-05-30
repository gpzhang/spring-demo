package com.demo.spring.bean;

import org.springframework.stereotype.Component;

/**
 * @author haishen
 * @date 2019/3/26
 */
@Component
public class Book {

    private String name = "java";

    public Book() {
        System.out.println("实例化Book," + "Thread:[" + Thread.currentThread().getName() + "]");
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
