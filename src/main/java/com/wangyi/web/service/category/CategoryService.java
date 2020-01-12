package com.wangyi.web.service.category;

import com.wangyi.web.pojo.Category;

import java.util.List;

/**
 * @ClassName CategoryService
 * @Description TODO
 * @Author Wrysunny
 * @Date 2020/1/1120:00
 * @Version 1.0
 **/
public interface CategoryService {
    List<Category> selCategory(Category category);
    int saveCategory(Category category);
    int delCategory(Category category);
}
