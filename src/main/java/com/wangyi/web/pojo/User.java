package com.wangyi.web.pojo;

import lombok.Data;

/**
 * @ClassName User
 * @Description TODO
 * @Author Wrysunny
 * @Date 2020/1/1023:46
 * @Version 1.0
 **/
@Data
public class User {
    private Integer id;
    private String username;
    private String name;
    private String password;
    private String phone;
    private Integer isActive;
}
