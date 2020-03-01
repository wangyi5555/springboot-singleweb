package com.wangyi.web.Controller.webpage;

import com.wangyi.web.annotation.GetSidebarMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName AboutController
 * @Description TODO
 * @Author Wrysunny
 * @Date 2020/1/1814:00
 * @Version 1.0
 **/
@Controller
public class AboutController {
    @GetSidebarMessage
    @RequestMapping("/about")
    public String aboutPage(){
        return "webpage/about";
    }
}
