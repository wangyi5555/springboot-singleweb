package com.wangyi.web.Controller.manager;

import com.github.pagehelper.PageInfo;
import com.wangyi.web.pojo.User;
import com.wangyi.web.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName ManagerPageController
 * @Description TODO 负责管理首页的Controller
 * @Author Wrysunny
 * @Date 2020/1/1021:55
 * @Version 1.0
 **/
@Controller
@RequestMapping("/manager")
public class IndexController {

    /*
     * @Author Wrysunny
     * @Description //TODO 管理页面的首页
     * @Date 12:16 2020/1/11
     * @Param []
     * @return java.lang.String
     **/
    @GetMapping("/index")
    public String managerIndexPage(){
        return "manager/index";
    }



}
