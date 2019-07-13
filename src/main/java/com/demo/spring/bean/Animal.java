package com.demo.spring.bean;

/**
 * @author haishen
 * @date 2018/8/2
 */
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
