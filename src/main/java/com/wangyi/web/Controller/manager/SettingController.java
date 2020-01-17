package com.wangyi.web.Controller.manager;

import com.wangyi.web.pojo.Setting;
import com.wangyi.web.service.setting.SettingService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName SettingController
 * @Description TODO
 * @Author Wrysunny
 * @Date 2020/1/1716:11
 * @Version 1.0
 **/
@Controller
@RequestMapping("/manager")
@RequiresPermissions("manager:*:setting")
public class SettingController {
    @Autowired
    private SettingService settingService;
    @GetMapping("/setting")
    public String settingPage(Model model){
        System.out.println("111");
        Setting setting = settingService.selSetting();
        model.addAttribute("setting", setting);
        return "manager/setting";
    }
    @PutMapping("/setting/update")
    public String updateSetting(Setting setting){
        settingService.updSetting(setting);
        return "redirect:/manager/setting";
    }
}
