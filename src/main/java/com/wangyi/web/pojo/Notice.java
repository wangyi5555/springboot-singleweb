package com.wangyi.web.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * @ClassName Notice
 * @Description TODO
 * @Author Wrysunny
 * @Date 2020/1/1612:58
 * @Version 1.0
 **/
@Data
@Component
public class Notice {
    private Integer id;
    private String title;
    private String content;
    private String keywords;
    private String description;
    private Integer visibility;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp lasttime;
}
