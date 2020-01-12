package com.wangyi.web.common;

import com.wangyi.web.pojo.Category;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @ClassName CategoryCommon
 * @Description TODO category的工具类
 * @Author Wrysunny
 * @Date 2020/1/1120:45
 * @Version 1.0
 **/
public class CategoryCommon {
    public static List<Category> sortList(List<Category> list){
        //按父id分组返回map
        Map<Integer, List<Category>> map = list.stream().collect(Collectors.groupingBy(Category::getFatherID));
        List<Category> newlist = new ArrayList<>();
        List<Category> root = map.get(0);
        //开始排父子顺序
        for (int i = 0; i < root.size();i++) {
            Category parent = root.get(i);
            newlist.add(parent);
            List<Category> children = map.get(parent.getId());
            if(children!=null){
                newlist.addAll(children);
            }
        }
        return newlist;
    }

    public static List<Category> getOption(List<Category> list) {
        List<Category> newlist = list.stream().filter((t) -> t.getFatherID() == 0).collect(Collectors.toList());
        return newlist;
    }
}
