package com.wangyi.web.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName User
 * @Description TODO
 * @Author Wrysunny
 * @Date 2020/1/1023:46
 * @Version 1.0
 **/
@Data
public class User {
//    用户唯一编号
    private Integer id;
//    用户登录名
    private String username;
//    用户真实姓名
    private String name;
//    用户密码
    private String password;
//    用户电话
    private String phone;
//    用户是否激活：0 1
    private Integer isActive;

    private Role role = new Role();

    private List<LoginLog> loginLog;
}
