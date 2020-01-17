package com.wangyi.web;

import com.wangyi.web.common.CategoryCommon;
import com.wangyi.web.dao.*;
import com.wangyi.web.pojo.*;
import com.wangyi.web.service.category.CategoryService;
import com.wangyi.web.service.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class WebApplicationTests {


    @Autowired
    private FlinkMapper flinkMapper;

    @Test
    void contextLoads() {
        Flink flink = new Flink();
        User user = new User();
        user.setId(18);
        Role role = new Role();
        role.setId(1);
        user.setRole(role);


        flink.setWriterbean(user);

        System.out.println(flink);
        List<Flink> flinks = flinkMapper.selFlink(flink);
        flinks.forEach(System.out::println);
    }


}
