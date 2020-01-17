package com.wangyi.web.dao;

import com.wangyi.web.pojo.Setting;

/**
 * @ClassName SettingMapper
 * @Description TODO
 * @Author Wrysunny
 * @Date 2020/1/1717:27
 * @Version 1.0
 **/
public interface SettingMapper {
    Setting selSetting();

    int updSetting(Setting setting);
}
