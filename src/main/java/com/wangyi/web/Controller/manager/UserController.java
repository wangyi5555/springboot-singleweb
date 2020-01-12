package com.wangyi.web.Controller.manager;

import com.github.pagehelper.PageInfo;
import com.wangyi.web.pojo.common.ResponseMessage;
import com.wangyi.web.pojo.User;
import com.wangyi.web.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName UserController
 * @Description TODO 负责用户的管理器
 * @Author Wrysunny
 * @Date 2020/1/1112:18
 * @Version 1.0
 **/

@Controller
@RequestMapping("/manager")
public class UserController {
    @Autowired
    private UserService userService;
    /*
     * @Author Wrysunny
     * @Description //TODO 用户信息展示的页面
     * @Date 12:17 2020/1/11
     * @Param []
     * @return java.lang.String
     **/
    @GetMapping("/user/{pageNum}")
    public String userPage(Model model,
                           @PathVariable(name = "pageNum") Integer pageNum,
                           HttpServletRequest request){
        System.out.println(request.getRequestURL());
        List<User> userList = userService.selAllUser(pageNum);
        PageInfo<User> pageInfo = new PageInfo<>(userList);
//        System.out.println(pageInfo.getNextPage());
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("userList", userList);
        return "manager/manage-user";
    }

    /*
     * @Author Wrysunny
     * @Description //TODO 根据用户id查找用户信息
     * @Date 19:06 2020/1/11
     * @Param [id]
     * @return com.wangyi.web.pojo.User
     **/
    @PostMapping("/user/getbyID")
    @ResponseBody
    public User user(User user){
        return userService.selUserByID(user);
    }

    /*
     * @Author Wrysunny
     * @Description //TODO 新增一个用户
     * @Date 15:31 2020/1/11
     * @Param [user]
     * @return java.lang.String
     **/
    @PostMapping("/user/add")
    public String addUser(User user){
        userService.saveUser(user);
        return "redirect:/manager/user/1";
    }

    /*
     * @Author Wrysunny
     * @Description //TODO 修改用户的状态
     * @Date 16:58 2020/1/11
     * @Param [user]
     * @return com.wangyi.web.pojo.common.ResponseMessage
     **/
    @PutMapping("/user/actived")
    @ResponseBody
    public ResponseMessage activedUser(User user){
        userService.saveUser(user);
        return new ResponseMessage();
    }

    /*
     * @Author Wrysunny
     * @Description //TODO 更新用户信息
     * @Date 10:16 2020/1/12
     * @Param [user, oldpassword]
     * @return java.lang.String
     **/
    @PutMapping("/user/update")
    public String updateUser(User user,String oldpassword){
        userService.saveUser(user);
        return "redirect:/manager/user/1";
    }
    

    /*
     * @Author Wrysunny
     * @Description //TODO 删除指定id的用户
     * @Date 16:15 2020/1/11
     * @Param [id]
     * @return com.wangyi.web.pojo.common.ResponseMessage
     **/
    @DeleteMapping("/user/delete")
    @ResponseBody
    public ResponseMessage deleteUser(@RequestParam("id") int id){
        userService.delUser(id);
        return new ResponseMessage();
    }

    @DeleteMapping("/user/delList")
    public String delList(@RequestParam(value = "checkbox[]",required = false) Integer[] checkbox) {
        userService.delbyList(checkbox);
        return "redirect:/manager/user/1";
    }
}
