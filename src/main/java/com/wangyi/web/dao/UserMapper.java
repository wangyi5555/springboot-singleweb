package com.wangyi.web.dao;

import com.wangyi.web.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author Wrysunny
 * @Date 2020/1/1023:52
 * @Version 1.0
 **/

public interface UserMapper {
    /*
     * @Author Wrysunny
     * @Description //TODO 查询用户信息
     * @Date 15:03 2020/1/11
     * @Param []
     * @return java.util.List<com.wangyi.web.pojo.User>
     **/
    List<User> selUser(User user);


    /*
     * @Author Wrysunny
     * @Description //TODO 插入用户信息
     * @Date 15:03 2020/1/11
     * @Param [user]
     * @return int
     **/
    int insUser(User user);

    /*
     * @Author Wrysunny
     * @Description //TODO 更新用户信息
     * @Date 15:04 2020/1/11
     * @Param [user]
     * @return int
     **/
    int updUser(User user);

    /*
     * @Author Wrysunny
     * @Description //TODO 删除指定的用户记录
     * @Date 15:04 2020/1/11
     * @Param [user]
     * @return int
     **/
    int delUser(int id);
}
