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
    @Select("select * from tb_user")
    List<User> selAllUser();
}
