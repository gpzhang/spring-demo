package com.demo.spring.bean;

/**
 * @author haishen
 * @date 2019/3/21
 * FactoryBean 获取bean
 */
public class Computer {

    public Computer(){
        System.out.println("实例化Computer");
    }

    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void add(int a, int b) {
        System.out.println("计算结果:" + (a + b));
    }
}
