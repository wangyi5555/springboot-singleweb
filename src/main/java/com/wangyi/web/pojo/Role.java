package com.wangyi.web.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @ClassName Role
 * @Description TODO 用户角色实例
 * @Author Wrysunny
 * @Date 2020/1/1710:41
 * @Version 1.0
 **/
@Data
@Component
public class Role {
    private Integer id;
    private String perms;
}
