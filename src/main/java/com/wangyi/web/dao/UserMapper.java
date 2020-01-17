package com.wangyi.web.dao;

import com.wangyi.web.pojo.User;

import java.util.List;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author Wrysunny
 * @Date 2020/1/1023:52
 * @Version 1.0
 **/

public interface UserMapper {

    List<User> selUser(User user);

    User selUserWithAll(User user);

    int insUser(User user);

    int updUser(User user);

    int delUser(int id);
}
