package com.wangyi.web.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @ClassName Comment
 * @Description TODO
 * @Author Wrysunny
 * @Date 2020/2/2215:16
 * @Version 1.0
 **/
@Data
public class Comment {
    private Integer id;
    private String username;
    private String email;
    private String content;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp date;
    private Integer belong_id = 0;
}
