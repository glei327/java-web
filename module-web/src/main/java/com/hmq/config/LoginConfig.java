package com.hmq.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


@Data
@ConfigurationProperties(prefix = "generalconfig.login")
public class LoginConfig {

    /**
     * 登陆拦截URL
     */
    private String[] includeUrls;

    /**
     * 不进行登陆拦截的URL
     */
    private String[] excludeUrls;


}

