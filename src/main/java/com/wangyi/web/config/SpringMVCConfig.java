package com.wangyi.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName SpringMVCConfig
 * @Description TODO
 * @Author Wrysunny
 * @Date 2020/1/1620:32
 * @Version 1.0
 **/
@Configuration
public class SpringMVCConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**").addResourceLocations("file:H://upload/");
    }
}
