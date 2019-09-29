package com.hmq;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.hmq.common.util.Sequence;
import com.hmq.common.util.SequenceUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Package: com.hmq
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
@MapperScan("com.hmq.dao")
//@ImportResource(locations = {"classpath:/spring/spring-*.xml"})
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class,args);
    }

    @Bean
    @ConfigurationProperties("spring.datasource.druid")
    public DataSource dataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    public Sequence getSequence(){
        Sequence sequence = new Sequence();
        sequence.setDataSource(dataSource());
        sequence.setBlockSize(100);
        return sequence;
    }

    @Bean
    public SequenceUtil getSequenceUtil(){
        SequenceUtil sequenceUtil = new SequenceUtil();
        sequenceUtil.setDefaultSequence(getSequence());
        return sequenceUtil;
    }
}
