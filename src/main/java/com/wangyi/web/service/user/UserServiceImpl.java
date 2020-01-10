package com.wangyi.web.service.user;

import com.wangyi.web.dao.UserMapper;
import com.wangyi.web.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author Wrysunny
 * @Date 2020/1/1023:54
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> selAllUser() {
        return userMapper.selAllUser();
    }
}
