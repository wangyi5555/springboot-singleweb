package com.wangyi.web.service.loginlog;

import com.wangyi.web.pojo.LoginLog;

import java.util.List;

/**
 * @ClassName LoginlogServices
 * @Description TODO
 * @Author Wrysunny
 * @Date 2020/1/1216:56
 * @Version 1.0
 **/
public interface LoginlogServices {
    List<LoginLog> selAllLog(Integer pageNum);

    int delLogByID(Integer id);

    int delByList(Integer[] checkbox);

    int insLog(LoginLog loginLog);
}
