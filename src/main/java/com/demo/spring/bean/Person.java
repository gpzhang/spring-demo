package com.demo.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author haishen
 * @date 2018/8/30
 * bean的生命周期
 */
public class Person implements BeanNameAware, BeanFactoryAware,
        ApplicationContextAware, InitializingBean, DisposableBean, ApplicationListener<ContextRefreshedEvent> {

    private String name;

    public Person() {
        System.out.println("实例化Persons");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("set Person的属性Name前--->" + this.name);
        this.name = name;
        System.out.println("set Person的属性Name后--->" + name);
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("实例化Persons,调用BeanNameAware.setBeanName()-->" + s);

    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("实例化Persons,调用BeanFactoryAware.setBeanFactory()-->");

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("实例化Persons,调用ApplicationContextAware.setApplicationContext-->");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("实例化Persons,调用InitializingBean.afterPropertiesSet-->");
    }

    public void init() {
        System.out.println("我自己写了一个init()方法");
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("实例化Persons,调用ApplicationListener.onApplicationEvent-->");

    }

    @Override
    public void destroy() throws Exception {
        System.out.println("实例化Persons,调用DisposableBean.destroy()");

    }
}
