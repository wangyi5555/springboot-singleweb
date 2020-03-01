package com.wangyi.web.dao;

import com.wangyi.web.pojo.LoginLog;

import java.util.List;

/**
 * @ClassName LoginLogMapper
 * @Description TODO
 * @Author Wrysunny
 * @Date 2020/1/1215:50
 * @Version 1.0
 **/
public interface LoginLogMapper {
    List<LoginLog> selAllLoginLog(LoginLog loginLog);

    int delLoginLog(Integer id);

    int insLoginLog(LoginLog loginLog);

}
