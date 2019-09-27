package com.gl.interceptor;

import com.gl.config.LogConfig;
import com.gl.config.LoginConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * 请求拦截器配置类
 *
 * @author dengjinjin
 * @date 2018-10-15
 */
@Slf4j
@Configuration
@EnableConfigurationProperties(value = {LoginConfig.class,LogConfig.class})
public class InterceptorConfig extends WebMvcConfigurationSupport {


    @Autowired
    private LoginConfig loginConfig;

    @Autowired
    private LogConfig logConfig;


    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        /*MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        //设置日期格式
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleDateFormat smt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        objectMapper.setDateFormat(smt);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false );
        mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper);
        //设置中文编码格式
        List<MediaType> list = new ArrayList<MediaType>();
        list.add(MediaType.APPLICATION_JSON_UTF8);
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(list);
        converters.add(mappingJackson2HttpMessageConverter);*/

        converters.removeIf(httpMessageConverter -> httpMessageConverter instanceof MappingJackson2HttpMessageConverter);
        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        converter.setGson(gson);
        converters.add(converter);
        super.extendMessageConverters(converters);
    }

//    @Override
//    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//    }


    @Bean
    public LoginInterceptor getLoginInterceptor() {
        return new LoginInterceptor();
    }

    @Bean
    public LogInterceptor getLogInterceptor() {
        return new LogInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        InterceptorRegistration loginInterceptorRegistration = registry.addInterceptor(getLoginInterceptor());
        loginInterceptorRegistration.addPathPatterns(loginConfig.getIncludeUrls());
        if (null != loginConfig.getExcludeUrls() && loginConfig.getExcludeUrls().length > 0) {
            loginInterceptorRegistration.excludePathPatterns(loginConfig.getExcludeUrls());
        }

        /*registry.addInterceptor(getLogInterceptor()).addPathPatterns(logConfig.getIncludeUrls());
        if (null != logConfig.getExcludeUrls() && logConfig.getExcludeUrls().length > 0) {
            loginInterceptorRegistration.excludePathPatterns(logConfig.getExcludeUrls());
        }*/
        registry.addInterceptor(getLogInterceptor()).addPathPatterns("/**");

        super.addInterceptors(registry);
    }

}


