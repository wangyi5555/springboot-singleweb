package com.wangyi.web.service.loginlog;

import com.github.pagehelper.PageHelper;
import com.wangyi.web.dao.LoginLogMapper;
import com.wangyi.web.pojo.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName LoginLogServiceImpls
 * @Description TODO
 * @Author Wrysunny
 * @Date 2020/1/1216:56
 * @Version 1.0
 **/
@Service
public class LoginLogServiceImpl implements LoginlogServices {
    @Autowired
    private LoginLogMapper loginLogMapper;
    @Override
    public List<LoginLog> selAllLog(Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        return loginLogMapper.selAllLoginLog(new LoginLog());
    }

    @Override
    public int delLogByID(Integer id) {
        return loginLogMapper.delLoginLog(id);
    }

    @Override
    public int delByList(Integer[] checkbox) {
        for (int i :
                checkbox) {
            loginLogMapper.delLoginLog(i);
        }
        return checkbox.length;
    }
}
