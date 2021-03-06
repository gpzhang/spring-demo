package com.demo.spring;

import com.demo.spring.bean.Library;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类等价于spring的配置文件
 *
 * @author haishen
 * @date 2019/3/27
 */

@Configuration
@ComponentScan(value = "com.demo.spring")
public class AppConfig {

    public AppConfig() {
        System.out.println("实例化AppConfig");
    }

    @Bean
    public Library getLibrary() {
        return new Library();
    }

}