package com.demo.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author haishen
 * @date 2019/3/26
 */
@Component
public class Book {

    @Autowired
    private Desk desk;

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
        System.out.println("desk:[" + desk + "],book:[" + name + "]");
    }
}
