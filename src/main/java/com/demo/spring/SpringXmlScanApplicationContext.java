package com.demo.spring;

import com.demo.spring.bean.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Spring 基于配置文件扫描管理bean
 * <p>
 * Spring　IoC容器对于类级别的注解和类内部的注解分以下两种处理策略：
 * <p>
 * (1).类级别的注解：如@Component、@Repository、@Controller、@Service以及JavaEE6的@ManagedBean和@Named注解，
 * 都是添加在类上面的类级别注解，Spring容器根据注解的过滤规则扫描读取注解Bean定义类，并将其注册到Spring IoC容器中。
 * <p>
 * (2).类内部的注解：如@Autowire、@Value、@Resource以及EJB和WebService相关的注解等，
 * 都是添加在类内部的字段或者方法上的类内部注解，SpringIoC容器通过Bean后置注解处理器解析Bean内部的注解。
 *
 * @author haishen
 */
public class SpringXmlScanApplicationContext {

    public static void main(String[] args) {
        getBookBeanByXml();
    }

    /**
     * 类级别的注解定义的bean的加载，以及属性注解
     * 1、解析注解扫描的标签<context:component-scan base-package="com.demo.spring" annotation-config="false"/>
     * 创建扫描器对象ClassPathBeanDefinitionScanner
     * 2、扫描器对象ClassPathBeanDefinitionScanner扫描指定包路径下的类，过滤出带有@Component类型注解的实现类,
     * 注册到spring容器中,作为可以被spring管理的bean
     * 3、发送注册完成通知事件，同时根据配置信息（annotation-config=true）判断是否添加属性注解的处理器注册
     * 4、等到创建bean的时候（具体是对已创建的bean填充属性的时候）使用这些注解处理器
     *
     * @return
     */
    private static Book getBookBeanByXml() {
        //初始化spring容器，使用xml文件，所以用ClasspathXmlApplicationContext
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-scan-bean.xml");
        Book book = (Book) context.getBean("book");
        System.out.println(book.toString());
        book.say();
        return book;
    }


/**
 * 循环依赖的问题
 * 单例的bean，通过set注入的循环依赖，可以被解决，解决方法通过缓存拿到依赖的bean
 * 单例的bean，通过有参构造函数注入的循环依赖，不可以被解决，因为通过缓存拿不到依赖的bean
 * 原型模式的循环依赖无法解决，抛出异常，因为原型模式的bean依赖时直接创建，不会缓存
 */

}
