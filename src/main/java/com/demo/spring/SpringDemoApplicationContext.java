package com.demo.spring;

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


/**
 * Spring 基于配置文件管理bean
 * <p>
 * 当我们使用ApplicationContext去获取bean的时候，
 * 在加载XXX.xml的时候，会创建所有的配置非懒加载的bean。
 * <p>
 * 没有特殊要求的情况下，应该使用ApplicationContext完成。
 * 因为BeanFactory能完成的事情，ApplicationContext都能完成，
 * 并且提供了更多接近现在开发的功能。
 * <p>
 * BeanFactory和ApplicationContext的作用、相同、区别
 * 作用：都是用来对bean的生命周期进行管理
 * 相同：都是加载bean
 * 区别：
 * bean的加载时机不同，BeanFactory当调用getBean的时候，才会实时实例化该bean对象；
 * ApplicationContext容器启动完成后就会加载非懒加载的单例bean。
 * ApplicationContext除了提供BeanFactory所能提供的功能之外，还提供了更多的框架功能
 *
 * @author haishen
 */
public class SpringDemoApplicationContext {

    public static void main(String[] args) {

//        People people = getPeopleBeanByXml();

        Person person = getPersonBeanByXml();

//        Animal animal = getAnimalBeanByBeanDefinitionRegister();


//        Computer computer = getComputerBeanByFactoryBean();
//        computer.add(1, 2);
    }

    /**
     * 一个通过自定义标签管理的bean的加载
     *
     * @return
     */
    private static People getPeopleBeanByXml() {
        //初始化spring容器，使用xml文件，所以用ClasspathXmlApplicationContext
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");
        People people = (People) context.getBean("cutesource");
        System.out.println(people.toString());
        return people;
    }

    /**
     * 一个涵盖了bean生命周期重要节点的bean的加载
     *
     * @return
     */
    private static Person getPersonBeanByXml() {
        //初始化spring容器，使用xml文件，所以用ClasspathXmlApplicationContext
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");
        Person person = (Person) context.getBean("person");
        System.out.println(person.getName());
        return person;
    }

    /**
     * 获取实现了FactoryBean接口的bean
     *
     * @return
     */
    private static Computer getComputerBeanByFactoryBean() {
        //初始化spring容器，使用xml文件，所以用ClasspathXmlApplicationContext
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");
        return (Computer) context.getBean("myFactoryBean");
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


}
