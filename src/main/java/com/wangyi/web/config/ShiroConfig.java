package com.wangyi.web.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.wangyi.web.compoment.realm.UserRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName ShiroConfig
 * @Description TODO
 * @Author Wrysunny
 * @Date 2020/1/1315:53
 * @Version 1.0
 **/
@Configuration
public class ShiroConfig {

    /*
     * @Author Wrysunny
     * @Description //TODO 配置themleaf支持shiro
     * @Date 16:02 2020/1/17
     * @Param []
     * @return at.pollux.thymeleaf.shiro.dialect.ShiroDialect
     **/
    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }
    /*
     * @Author Wrysunny
     * @Description //TODO 设置shiro注解启动
     * @Date 16:02 2020/1/17
     * @Param [defaultWebSecurityManager]
     * @return org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor
     **/
//    @Bean
//    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("defaultWebSecurityManager")DefaultWebSecurityManager defaultWebSecurityManager) {
//        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
//        advisor.setSecurityManager(defaultWebSecurityManager);
//        return advisor;
//    }
//
//    @Bean
//    @ConditionalOnMissingBean
//    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
//        DefaultAdvisorAutoProxyCreator app = new DefaultAdvisorAutoProxyCreator();
//        app.setProxyTargetClass(true);
//        return app;
//    }
    /*
     * @Author Wrysunny
     * @Description //TODO shiroFilter注册器
     * @Date 16:02 2020/1/17
     * @Param [defaultWebSecurityManager]
     * @return org.apache.shiro.spring.web.ShiroFilterFactoryBean
     **/
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        Map<String, String> params = new LinkedHashMap<>();
        params.put("/manager/login","anon");
        params.put("/manager/login/check", "anon");
        params.put("/manager/logout", "logout");
        params.put("/manager/category/**", "perms[manager:*:category]");
        params.put("/manager/user/**", "perms[manager:*:user]");
        params.put("/manager/notice/**", "perms[manager:*:notice]");
        params.put("/manager/loginlog/**", "perms[manager:*:loginlog]");
        params.put("/manager/**", "authc");
        Map<String, Filter> filterMap = new LinkedHashMap<>();
//        注册重写的filter
        filterMap.put("logout", logoutFilter());
        shiroFilterFactoryBean.setFilters(filterMap);
        shiroFilterFactoryBean.setFilterChainDefinitionMap(params);
        shiroFilterFactoryBean.setLoginUrl("/manager/login");
        shiroFilterFactoryBean.setSuccessUrl("/manager/index");
        return shiroFilterFactoryBean;
    }

    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm,
                                                               @Qualifier("cookieRememberMeManager") CookieRememberMeManager cookieRememberMeManager) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(userRealm);
        defaultWebSecurityManager.setRememberMeManager(cookieRememberMeManager);
        return defaultWebSecurityManager;
    }
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }

    @Bean
    public CookieRememberMeManager cookieRememberMeManager(@Qualifier("rememberMeCookie") SimpleCookie cookie){
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(cookie);
        return cookieRememberMeManager;
    }
    @Bean
    public SimpleCookie rememberMeCookie() {
        SimpleCookie cookie = new SimpleCookie("rememberMe");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(1 * 60 * 60);
        return cookie;
    }

    public LogoutFilter logoutFilter(){
        LogoutFilter logoutFilter = new LogoutFilter();
        logoutFilter.setRedirectUrl("/manager/login");
        return logoutFilter;
    }
}
