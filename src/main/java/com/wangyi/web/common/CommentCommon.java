package com.wangyi.web.common;

import com.wangyi.web.pojo.Comment;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName CommentCommon
 * @Description TODO 评论处理工具
 * @Author Wrysunny
 * @Date 2020/2/2215:43
 * @Version 1.0
 **/
public class CommentCommon {
    public static List<Comment> sortByTime(List<Comment> list){
        return list.stream()
                .sorted(Comparator.comparing(Comment::getDate).reversed())
                .collect(Collectors.toList());
    }
}
