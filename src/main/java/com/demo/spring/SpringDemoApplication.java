package com.demo.spring;

import com.demo.spring.api.DemoDao;
import com.demo.spring.bean.*;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@ComponentScan
public class SpringDemoApplication {

    public static void main(String[] args) {
        quanZhuJie();
//        getLibraryByXml();
//        People people = getPeopleBeanByXml();

//        Person person = getPersonBeanByXml();

//        Animal animal = getAnimalBeanByBeanDefinitionRegister();

//        Book book = getBookByZhujie();
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


    /**
     * ---------------------
     * Spring　IoC容器对于类级别的注解和类内部的注解分以下两种处理策略：
     * <p>
     * (1).类级别的注解：如@Component、@Repository、@Controller、@Service以及JavaEE6的@ManagedBean和@Named注解，都是添加在类上面的类级别注解，Spring容器根据注解的过滤规则扫描读取注解Bean定义类，并将其注册到Spring IoC容器中。
     * <p>
     * (2).类内部的注解：如@Autowire、@Value、@Resource以及EJB和WebService相关的注解等，都是添加在类内部的字段或者方法上的类内部注解，SpringIoC容器通过Bean后置注解处理器解析Bean内部的注解。
     * ---------------------
     * spring 全注解注入处理类级别注解的关键节点
     * 1、创建一个拥有@Configuration的注解类
     * 2、通过注解指定自动装配的扫描路径@ComponentScan(value = "com.demo.spring")
     * 3、通过AnnotationConfigApplicationContext上下文容器进行加载
     * 4、初始化AnnotationConfigApplicationContext对象时会执行this.reader = new AnnotatedBeanDefinitionReader(this);
     * 5、调用了AnnotationConfigUtils.registerAnnotationConfigProcessors(this.registry);其中注册了ConfigurationClassPostProcessor；
     * 6、ConfigurationClassPostProcessor实现了BeanFactoryPostProcessor接口,
     * 7、在spring容器初始化过程中,会通过执行invokeBeanFactoryPostProcessors(beanFactory)方法,
     * 8、在7方法内部执行了ConfigurationClassPostProcessor的postProcessBeanDefinitionRegistry(registry)方法;
     * 9、在8方法内部通过执行ConfigurationClassParser.parse(),
     * 10、继而执行到另外一个方法doProcessConfigurationClass(),
     * 11、在10该方法内部执行了ComponentScanAnnotationParser的parse()方法,
     * 12、在11方法内部执行了ClassPathBeanDefinitionScanner的doScan()方法,
     * 13、最后完成符合注解条件的bean的定义,未后续bean的加载准备好bean信息
     */

    private static void quanZhuJie() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        String[] names = ctx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

    }
}
