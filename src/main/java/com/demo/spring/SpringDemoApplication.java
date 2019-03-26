package com.demo.spring;

import com.demo.spring.api.DemoDao;
import com.demo.spring.bean.*;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemoApplication {

    public static void main(String[] args) {
        getLibraryByXml();
//        People people = getPeopleBeanByXml();

//        Person person = getPersonBeanByXml();

//        Animal animal = getAnimalBeanByBeanDefinitionRegister();

//        Library book = getBookByZhujie();
//
//        Computer computer = getComputerBeanByFactoryBean();
//        computer.add(1, 2);
//        aopDemo();
    }

    private static People getPeopleBeanByXml() {
        //初始化spring容器，使用xml文件，所以用ClasspathXmlApplicationContext
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-bean.xml");
        People people = (People) ctx.getBean("cutesource");
        System.out.println(people.toString());
        return people;
    }

    private static Person getPersonBeanByXml() {
        //初始化spring容器，使用xml文件，所以用ClasspathXmlApplicationContext
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-bean.xml");
        return null;

//        Person person = (Person) ctx.getBean("person");
//        System.out.println(person.getName());
//        return person;
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
        Animal animal = (Animal) beanFactory.getBean("animal");
        animal.say();
        return animal;
    }

    private static Computer getComputerBeanByFactoryBean() {
        //初始化spring容器，使用xml文件，所以用ClasspathXmlApplicationContext
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");
        return (Computer) context.getBean("myFactoryBean");
    }

    private static void aopDemo() {
        //初始化spring容器，使用xml文件，所以用ClasspathXmlApplicationContext
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");
        DemoDao demoDao = (DemoDao) context.getBean("demoDaoImpl");
        demoDao.insert();
    }

    private static Book getBookByZhujie() {
        //初始化spring容器，使用xml文件，所以用ClasspathXmlApplicationContext
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");
        Book book = (Book) context.getBean("book");
        book.say();
        return book;
    }

    private static Library getLibraryByXml() {
        //初始化spring容器，使用xml文件，所以用ClasspathXmlApplicationContext
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");
        Library library = (Library) context.getBean("library");
        library.say();
        return library;
    }
}
