package com.wangyi.web.pojo;

import lombok.Data;

/**
 * @ClassName Category
 * @Description TODO 栏目
 * @Author Wrysunny
 * @Date 2020/1/1119:41
 * @Version 1.0
 **/
@Data
public class Category {
    private Integer id;
    private String name;
    private Integer fatherID;
    private String alias;
    private String keyword;
    private String description;
}
