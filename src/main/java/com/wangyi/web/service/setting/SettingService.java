package com.wangyi.web.service.setting;

import com.wangyi.web.pojo.Setting;

/**
 * @ClassName SettingService
 * @Description TODO
 * @Author Wrysunny
 * @Date 2020/1/1717:34
 * @Version 1.0
 **/
public interface SettingService {
    Setting selSetting();

    int updSetting(Setting setting);
}
