package com.wangyi.web.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @ClassName Setting
 * @Description TODO
 * @Author Wrysunny
 * @Date 2020/1/1717:19
 * @Version 1.0
 **/
@Data
@Component
public class Setting {
    private Integer id;
    private String title;
    private String secondtitle;
    private String url;
    private String keywords;
    private String description;
    private String email;
    private String icp;
    private Integer timeout;
}
