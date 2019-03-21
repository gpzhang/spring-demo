package com.demo.spring.config;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author haishen
 * @date 2018/6/17
 * Spring可扩展的XML Schema机制
 * <p>
 * 1、在资源目录META-INF下创建一个 XML Schema 文件，描述自定义的合法构建模块，也就是xsd文件
 * 2、自定义个处理器类，并实现NamespaceHandler接口
 * 3、自定义一个或多个解析器，实现BeanDefinitionParser接口
 */
public class MyNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("people", new PeopleBeanDefinitionParser());
    }
}
