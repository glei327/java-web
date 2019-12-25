package com.hmq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Package: com.hmq
 * Title: Application
 * Description: (用一句话描述该文件做什么)
 * Author: gaolei10
 * Date: 2019/9/25 20:31
 * version: v1.0
 */
@EnableRetry   //开启重试机制
@SpringBootApplication
@EnableAutoConfiguration //开启自动配置
@EnableAspectJAutoProxy   //开启aop
@EnableTransactionManagement  //开启spring事务管理
@PropertySource(value = "classpath:/prop/jdbc.properties", encoding = "utf-8")
@MapperScan("com.hmq.dao")
//@ImportResource(locations = {"classpath:/spring/spring-*.xml"})
public class WebApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class,args);
    }
}
