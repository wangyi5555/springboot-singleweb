package com.wangyi.web.Controller.manager;

import com.github.pagehelper.PageInfo;
import com.wangyi.web.pojo.LoginLog;
import com.wangyi.web.pojo.common.ResponseMessage;
import com.wangyi.web.service.loginlog.LoginlogServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName LoginLogController
 * @Description TODO
 * @Author Wrysunny
 * @Date 2020/1/1216:46
 * @Version 1.0
 **/
@Controller
@RequestMapping("/manager")
public class LoginLogController {
    @Autowired
    private LoginlogServices loginlogServices;

    @GetMapping("/loginlog/{pageNum}")
    public String loginLogPage(@PathVariable("pageNum") Integer pageNum,
                               Model model) {
        List<LoginLog> loginLogList = loginlogServices.selAllLog(pageNum);
        PageInfo<LoginLog> pageInfo = new PageInfo<>(loginLogList);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("loginLogList", loginLogList);
        return "manager/loginlog";
    }

    @DeleteMapping("/loginlog/delete")
    @ResponseBody
    public ResponseMessage deleteLoginlog(@RequestParam(value = "id",required = false) Integer id) {
        loginlogServices.delLogByID(id);
        return new ResponseMessage();
    }

    @DeleteMapping("/loginlog/delList")
    public String delList(@RequestParam(value = "checkbox[]",required = false) Integer[] checkbox) {
        loginlogServices.delByList(checkbox);
        return "redirect:/manager/loginlog/1";
    }
}
