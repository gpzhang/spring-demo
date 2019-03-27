package com.demo.spring.bean;

import org.springframework.stereotype.Component;

/**
 * @author haishen
 * @date 2019/3/27
 */
@Component
public class Desk {

    private String name = "A01";

    public Desk() {
        System.out.println("实例化Desk");
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
