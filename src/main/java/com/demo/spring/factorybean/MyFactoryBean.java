package com.demo.spring.factorybean;

import com.demo.spring.bean.Computer;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author haishen
 * @date 2018/8/2
 */
public class MyFactoryBean<T> implements FactoryBean<T> {

    public MyFactoryBean() {
        System.out.println("实例化MyFactoryBean");
    }

    @Override
    public T getObject() throws Exception {
        Computer computer = new Computer();
        computer.setType(1);
        return (T) computer;

    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
