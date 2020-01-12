package com.wangyi.web.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName DruidConfig
 * @Description TODO 关于druid的配置
 * @Author Wrysunny
 * @Date 2020/1/1111:00
 * @Version 1.0
 **/
@Configuration
public class DruidConfig {
    /*
     * @Author Wrysunny
     * @Description //TODO 配置druid的实例
     * @Date 11:02 2020/1/11
     * @Param []
     * @return javax.sql.DataSource
     **/
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }
    /*
     * @Author Wrysunny
     * @Description //TODO 配置druid的监控页面
     * @Date 11:11 2020/1/11
     * @Param []
     * @return org.springframework.boot.web.servlet.ServletRegistrationBean<javax.servlet.Servlet>
     **/
    @Bean
    public ServletRegistrationBean<Servlet> statViewServlet(){
        ServletRegistrationBean<Servlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        Map<String, String> param = new HashMap<>();
        param.put("loginUsername","admin");
        param.put("loginPassword","admin");
        bean.setInitParameters(param);
        return bean;
    }
    /*
     * @Author Wrysunny
     * @Description //TODO 配置druid的过滤器
     * @Date 11:14 2020/1/11
     * @Param []
     * @return org.springframework.boot.web.servlet.FilterRegistrationBean<javax.servlet.Filter>
     **/
    @Bean
    public FilterRegistrationBean<Filter> webStatFilterFilter(){
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>(new WebStatFilter());
        Map<String, String> param = new HashMap<>();
        param.put("exclusions","*.js,*.css,/druid/*");
        bean.setInitParameters(param);
        bean.setUrlPatterns(Collections.singletonList("/*"));
        return bean;
    }
}
