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


}
