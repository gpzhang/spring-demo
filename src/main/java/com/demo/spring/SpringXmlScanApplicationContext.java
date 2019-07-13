package com.demo.spring;

import com.demo.spring.bean.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Spring 基于配置文件扫描管理bean
 *
 * @author haishen
 */
public class SpringXmlScanApplicationContext {

    public static void main(String[] args) {
        getBookBeanByXml();
    }

    private static Book getBookBeanByXml() {
        //初始化spring容器，使用xml文件，所以用ClasspathXmlApplicationContext
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-scan-bean.xml");
        Book people = (Book) context.getBean("book");
        System.out.println(people.toString());
        return people;
    }


}
