package com.wangyi.web.dao;

import com.wangyi.web.pojo.Comment;

import java.util.List;

/**
 * @ClassName CommentMapper
 * @Description TODO
 * @Author Wrysunny
 * @Date 2020/2/2216:26
 * @Version 1.0
 **/
public interface CommentMapper {
    List<Comment> selComment();

    int insComment(Comment comment);
}
