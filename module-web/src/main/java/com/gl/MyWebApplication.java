package com.gl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Package: com.gl
 * Title: Application
 * Description: (用一句话描述该文件做什么)
 * Author: gaolei10
 * Date: 2019/9/25 20:31
 * version: v1.0
 */
@SpringBootApplication
@EnableAspectJAutoProxy   //开启aop
@EnableTransactionManagement  //开启spring事务管理
@PropertySource(value = "classpath:/prop/jdbc.properties", encoding = "utf-8")
//@MapperScan("com.gl.dao")
//@ImportResource(locations = {"classpath:/spring/spring-*.xml"})
public class MyWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyWebApplication.class,args);
    }
}
