package com.wangyi.web.service.user;

import com.wangyi.web.pojo.User;

import java.util.List;

/**
 * @ClassName UserService
 * @Description TODO 用户服务的接口
 * @Author Wrysunny
 * @Date 2020/1/1023:53
 * @Version 1.0
 **/
public interface UserService {
    List<User> selAllUser(int pageNum);
    User selUserWithLog(User user);
    User selUserByID(User user);
    int saveUser(User user);
    int delUser(int id);
    int delbyList(Integer[] list);
}
