package com.demo.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * spring 基于注解的bean管理
 *
 * @author haishen
 */
public class SpringFullConfigurationApplication {

    public static void main(String[] args) {
        fullConfiguration();
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
     * 5、调用了AnnotationConfigUtils.registerAnnotationConfigProcessors(this.registry)，注册了一些PostProcessor，用于对各种注解的支持;其中注册了ConfigurationClassPostProcessor；
     * 6、ConfigurationClassPostProcessor实现了BeanFactoryPostProcessor接口,
     * 7、在spring容器初始化过程中,会通过执行invokeBeanFactoryPostProcessors(beanFactory)方法,
     * 8、在7方法内部执行了ConfigurationClassPostProcessor的postProcessBeanDefinitionRegistry(registry)方法;
     * 9、在8方法内部通过执行ConfigurationClassParser.parse(),
     * 10、继而执行到另外一个方法doProcessConfigurationClass(),
     * 11、在10该方法内部执行了ComponentScanAnnotationParser的parse()方法,
     * 12、在11方法内部执行了ClassPathBeanDefinitionScanner的doScan()方法,
     * 13、最后完成符合注解条件的bean的定义,为后续bean的加载准备好bean信息
     */

    private static void fullConfiguration() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        String[] names = ctx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

    }

}
