package com.wangyi.web.service.category;


import com.wangyi.web.common.CategoryCommon;
import com.wangyi.web.dao.CategoryMapper;
import com.wangyi.web.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName CategoryServiceImpl
 * @Description TODO
 * @Author Wrysunny
 * @Date 2020/1/1120:01
 * @Version 1.0
 **/
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> selCategory(Category category) {
        //查找特定的id
        if (category.getId() != null) {
           return categoryMapper.selCategory(category);
        }
        return CategoryCommon.sortList(categoryMapper.selCategory(category));
    }


    @Override
    public int saveCategory(Category category) {
        if(category.getId()==null){
            return categoryMapper.insCategory(category);
        }else {
            return categoryMapper.updCategory(category);
        }
    }

    @Override
    public int delCategory(Category category) {
        List<Category> l1 = categoryMapper.selCategory(category);
        //判断是否是父节点，如果是则删除相关的子节点
        if (l1.size() > 0) {
            category.setFatherID(l1.get(0).getFatherID());
            if (category.getFatherID()==0){
                categoryMapper.delCategoryByFatherID(category);
            }
        }
        return categoryMapper.delCategoryByID(category);
    }
}
