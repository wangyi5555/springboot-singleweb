package com.wangyi.web.dao;


import com.wangyi.web.pojo.Category;

import java.util.List;

/**
 * @ClassName CategoryMapper
 * @Description TODO
 * @Author Wrysunny
 * @Date 2020/1/1119:43
 * @Version 1.0
 **/
public interface CategoryMapper {
    List<Category> selCategory(Category category);

    int insCategory(Category category);

    int updCategory(Category category);

    int delCategoryByID(Category category);

    int delCategoryByFatherID(Category category);
}
