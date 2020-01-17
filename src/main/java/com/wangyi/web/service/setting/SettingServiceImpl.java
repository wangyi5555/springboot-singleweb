package com.wangyi.web.service.setting;

import com.wangyi.web.dao.SettingMapper;
import com.wangyi.web.pojo.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName SettingServiceImpl
 * @Description TODO
 * @Author Wrysunny
 * @Date 2020/1/1717:36
 * @Version 1.0
 **/
@Service
public class SettingServiceImpl implements SettingService{
    @Autowired
    private SettingMapper settingMapper;
    @Override
    public Setting selSetting() {
        return settingMapper.selSetting();
    }

    @Override
    public int updSetting(Setting setting) {
        return settingMapper.updSetting(setting);
    }

}
