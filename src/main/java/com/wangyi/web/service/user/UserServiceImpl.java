package com.wangyi.web.service.user;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wangyi.web.dao.UserMapper;
import com.wangyi.web.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description TODO 用户服务的实体类
 * @Author Wrysunny
 * @Date 2020/1/1023:54
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    /*
     * @Author Wrysunny
     * @Description //TODO 分页查询所有的用户
     * @Date 15:05 2020/1/11
     * @Param []
     * @return java.util.List<com.wangyi.web.pojo.User>
     **/
    @Override
    public List<User> selAllUser(int pageNum) {
        PageHelper.startPage(pageNum, 5);
        return userMapper.selUser(new User());
    }

    @Override
    public User selUserByID(User user) {
        return userMapper.selUser(user).get(0);
    }

    /*
     * @Author Wrysunny
     * @Description //TODO 保存用户信息，包括更新和插入
     * @Date 15:06 2020/1/11
     * @Param [user]
     * @return int
     **/
    @Override
    public int saveUser(User user) {
        if (user.getId() == null) {
            return userMapper.insUser(user);
        }else{
            return userMapper.updUser(user);
        }
    }


    /*
     * @Author Wrysunny
     * @Description //TODO 删除用户记录
     * @Date 15:06 2020/1/11
     * @Param [user]
     * @return int
     **/
    @Override
    public int delUser(int id) {
        return userMapper.delUser(id);
    }

    @Override
    public int delbyList(Integer[] list) {
        for (int i :
                list) {
            userMapper.delUser(i);
        }
        return list.length;
    }
}
