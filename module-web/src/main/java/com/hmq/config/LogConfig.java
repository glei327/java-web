package com.hmq.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


@Data
@ConfigurationProperties(prefix = "generalconfig.log")
public class LogConfig {

    /**
     * 日志拦截URL
     */
//    private String[] includeUrls;

    /**
     * 不进行日志拦截的URL
     */
//    private String[] excludeUrls;


}

