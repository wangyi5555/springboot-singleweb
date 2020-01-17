package com.wangyi.web.Controller.manager;

import com.wangyi.web.pojo.User;
import com.wangyi.web.service.loginlog.LoginlogServices;
import com.wangyi.web.service.user.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author Wrysunny
 * @Date 2020/1/1315:20
 * @Version 1.0
 **/
@Controller
@RequestMapping("/manager")
public class LoginController {
    @Autowired
    private UserService userService;
    @GetMapping("/login")
    public String loginPage() {
        return "manager/login";
    }

    @PostMapping("/login/check")
    public String check(User user,
                        Model model,
                        HttpSession session
                        ) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());

        try {
            subject.login(token);
        } catch (AuthenticationException | AuthorizationException e) {
            if (e instanceof AuthenticationException) {
                model.addAttribute("returnMessage", "账号或密码错误");
            } else {
                model.addAttribute("returnMessage", "没有权限");
            }
            return "manager/login";
        }
        return "redirect:/manager/index";
    }
}
