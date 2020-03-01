package com.wangyi.web.Controller.webpage;

import com.wangyi.web.annotation.GetSidebarMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName TagController
 * @Description TODO
 * @Author Wrysunny
 * @Date 2020/1/1814:38
 * @Version 1.0
 **/
@Controller
public class TagController {
    @GetSidebarMessage
    @GetMapping("/tags")
    public String tagsPage(){
        return "webpage/tags";
    }
}
