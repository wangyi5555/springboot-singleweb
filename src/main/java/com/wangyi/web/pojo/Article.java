package com.wangyi.web.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;


/**
 * @ClassName Article
 * @Description TODO 文章实体类
 * @Author Wrysunny
 * @Date 2020/1/1520:11
 * @Version 1.0
 **/
@Data
@Component
public class Article {
    private Integer id;
    private String title;
    private String content;
    private String keywords;
    private String description;
    //栏目id
    private Integer category;
    private String tags;
    //标题图片url
    private String titlepic;
    //是否发布
    private Integer visibility;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp lasttime;

    private Category categorybean = new Category();

    //此处注意如果要在mapper文件作为条件来使用不能为空，所以最好在初始化时就赋值
    private User writerbean = new User();

}
