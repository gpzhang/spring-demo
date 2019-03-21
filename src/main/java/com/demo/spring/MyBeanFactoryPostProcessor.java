package com.demo.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.TypedStringValue;

/**
 * @author haishen
 * @date 2018/8/30
 * <p>
 * BeanFactoryPostProcessor是在spring容器加载了bean的定义文件之后，在bean实例化之前执行的。
 * 接口方法的入参是ConfigurableListableBeanFactory，使用该参数，可以获取到相关bean的定义信息
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("执行了beanFactoryPostProcessor");
        BeanDefinition bdefine = beanFactory.getBeanDefinition("person");
        MutablePropertyValues pv = bdefine.getPropertyValues();
        if (pv.contains("name")) {
            PropertyValue ppv = pv.getPropertyValue("name");
            TypedStringValue obj = (TypedStringValue) ppv.getValue();
            System.out.println("beanFactoryPostProcessor修改属性值前" + ((TypedStringValue) ppv.getValue()).getValue());
            if (obj.getValue().equals("hs")) {
                pv.addPropertyValue("name", "阿根延");
            }
        }
        //会延迟加载
        bdefine.setScope(BeanDefinition.SCOPE_PROTOTYPE);
    }
}

