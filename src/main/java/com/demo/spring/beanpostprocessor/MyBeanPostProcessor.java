package com.demo.spring.beanpostprocessor;

import com.demo.spring.bean.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author haishen
 * @date 2018/8/30
 * BeanPostProcessor是在spring容器加载了bean的定义文件并且实例化bean之后执行的。
 * BeanPostProcessor的执行顺序是在BeanFactoryPostProcessor之后
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    public MyBeanPostProcessor() {
        System.out.println("实例化MyBeanPostProcessor");
    }

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("postProcessBeforeInitialization被调用" + "[Object:" + o + "],[String:" + s + "]");
        if (o instanceof Person) {
            ((Person) o).setName("hs03");
        }
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("postProcessAfterInitialization被调用" + "[Object:" + o + "],[String:" + s + "]");
        if (o instanceof Person) {
            ((Person) o).setName("hs04");
        }
        return o;
    }
}
