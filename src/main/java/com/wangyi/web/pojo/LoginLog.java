package com.wangyi.web.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @ClassName LoginLog
 * @Description TODO 登录日志实体类
 * @Author Wrysunny
 * @Date 2020/1/1215:35
 * @Version 1.0
 **/
@Data
public class LoginLog {
    private Integer id;
    private Integer userid ;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp lasttime;
    private String ip;
    private int status;
    private User user;
}
