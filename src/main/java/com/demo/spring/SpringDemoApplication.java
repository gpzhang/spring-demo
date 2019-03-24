package com.demo.spring;

import com.demo.spring.api.DemoDao;
import com.demo.spring.bean.Animal;
import com.demo.spring.bean.Computer;
import com.demo.spring.bean.People;
import com.demo.spring.bean.Person;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemoApplication {

    public static void main(String[] args) {
//        People people = getPeopleBeanByXml();
//        System.out.println(people.toString());

        Person person = getPersonBeanByXml();
//        System.out.println(person.getName());

//        Animal animal = getAnimalBeanByBeanDefinitionRegister();
//        animal.say();
//
//        Computer computer = getComputerBeanByFactoryBean();
//        computer.add(1, 2);
//        aopDemo();
    }

    private static People getPeopleBeanByXml() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-bean.xml");
        return (People) ctx.getBean("cutesource");
    }

    private static Person getPersonBeanByXml() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-bean.xml");
        return null;
//        return (Person) ctx.getBean("person");
    }

    private static Animal getAnimalBeanByBeanDefinitionRegister() {
        //1、创建个bean工厂
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //2、创建一个bean的定义
        GenericBeanDefinition bd = new GenericBeanDefinition();
        //定义属性
        MutablePropertyValues mpvs = new MutablePropertyValues();
        PropertyValue pv = new PropertyValue("name", "Cat");
        mpvs.addPropertyValue(pv);
        //设置bean的类型和属性
        bd.setPropertyValues(mpvs);
        bd.setBeanClass(Animal.class);
        //3、将定义好bean注册到容器
        beanFactory.registerBeanDefinition("animal", bd);
        beanFactory.preInstantiateSingletons();
        //4、使用bean
        return (Animal) beanFactory.getBean("animal");
    }

    private static Computer getComputerBeanByFactoryBean() {
        //初始化spring容器，由于使用的是注解，没有xml文件，所有不再使用ClasspathXmlApplicationContext
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");
        return (Computer) context.getBean("myFactoryBean");
    }

    private static void aopDemo() {
        //初始化spring容器，由于使用的是注解，没有xml文件，所有不再使用ClasspathXmlApplicationContext
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");
        DemoDao demoDao = (DemoDao) context.getBean("demoDaoImpl");
        demoDao.insert();
    }
}
