package com.demo.spring;

import com.demo.spring.bean.Person;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;


/**
 * Spring 基于配置文件管理bean
 * <p>
 * 当我们使用BeanFactory去获取Bean的时候，我们只是实例化了该容器，
 * 而该容器中的bean并没有被实例化。
 * 当我们getBean的时候，才会实时实例化该bean对象。
 *
 * @author haishen
 */
public class SpringDemoBeanFactory {

    public static void main(String[] args) {
        Person person = getPersonBeanByXml();
    }


    private static Person getPersonBeanByXml() {
        //初始化spring容器，使用xml文件，所以用ClasspathXmlApplicationContext
        BeanFactory factory = new XmlBeanFactory(new ClassPathResource("spring-bean.xml"));
        Person person = (Person) factory.getBean("person");
        System.out.println(person.getName());
        return person;
    }


}
