package com.wangyi.web.Controller;

import com.wangyi.web.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName ManagerPageController
 * @Description TODO 负责管理页面的Controller
 * @Author Wrysunny
 * @Date 2020/1/1021:55
 * @Version 1.0
 **/
@Controller
@RequestMapping("/manager")
public class ManagerPageController {
    @Autowired
    private UserService userService;
    /*
     * @Author Wrysunny
     * @Description //TODO 负责管理页面的首页初始化
     * @Date 21:57 2020/1/10
     * @Param []
     * @return java.lang.String
     **/
    @GetMapping("/index")
    public String managerIndexPage(){
        userService.selAllUser();
        return "manager/index";
    }

    @GetMapping("/user")
    public String userPage(){
        return "manager/manage-user";
    }
}
