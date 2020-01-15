package com.wangyi.web;

import com.wangyi.web.common.CategoryCommon;
import com.wangyi.web.dao.CategoryMapper;
import com.wangyi.web.dao.LoginLogMapper;
import com.wangyi.web.dao.UserMapper;
import com.wangyi.web.pojo.Category;
import com.wangyi.web.pojo.LoginLog;
import com.wangyi.web.pojo.User;
import com.wangyi.web.service.category.CategoryService;
import com.wangyi.web.service.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class WebApplicationTests {
    @Autowired
    LoginLogMapper loginLogMapper;

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        LoginLog log = new LoginLog();
        log.setUserid(2);
        List<LoginLog> loginLogs = loginLogMapper.selAllLoginLog(log);
        System.out.println(loginLogs);
    }
    @Test
    void test1(){
        User user = new User();
        user.setId(2);
        List<User> users = userMapper.selUser(new User());
        System.out.println(users);
        User user1 = userMapper.selUserWithLoginLog(user);
        System.out.println(user1.getLoginLog());

    }

}
