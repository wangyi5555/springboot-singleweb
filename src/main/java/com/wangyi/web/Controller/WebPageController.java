package com.wangyi.web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName PageController
 * @Description TODO 负责博客展示的Controller
 * @Author Wrysunny
 * @Date 2020/1/1017:22
 * @Version 1.0
 **/
@Controller
public class WebPageController {
    /*
     * @Author Wrysunny
     * @Description //TODO 负责博客主页的初始化
     * @Date 21:57 2020/1/10
     * @Param []
     * @return java.lang.String
     **/
    @GetMapping({"/index","/"})
    public String webpageIndex(){
        return "webpage/index";
    }
}
