package com.wangyi.web.Controller.webpage;

import com.wangyi.web.annotation.GetSidebarMessage;
import com.wangyi.web.pojo.Flink;
import com.wangyi.web.pojo.User;
import com.wangyi.web.service.flink.FlinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @ClassName FriendlyController
 * @Description TODO
 * @Author Wrysunny
 * @Date 2020/1/1814:21
 * @Version 1.0
 **/
@Controller
public class FriendlyController {
    @Autowired
    private FlinkService flinkService;

    @GetSidebarMessage
    @GetMapping("/friendly")
    public String friendlyPage(Model model) {
        List<Flink> flinkList = flinkService.selAllFlink(1, new User());
        model.addAttribute("flinkList", flinkList);
        return "webpage/friendly";
    }
}
