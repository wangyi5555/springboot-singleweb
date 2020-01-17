package com.wangyi.web.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * @ClassName Flink
 * @Description TODO 友情链接实体类
 * @Author Wrysunny
 * @Date 2020/1/1211:31
 * @Version 1.0
 **/
@Data
@Component
public class Flink {
    private Integer id;
    private String name;
    private String url;
    private String imgurl;
    private String description;
    private String target;
    private String rel;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp lastDate;
    private User writerbean = new User();
}
