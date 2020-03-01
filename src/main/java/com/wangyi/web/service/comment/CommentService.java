package com.wangyi.web.service.comment;

import com.wangyi.web.pojo.Comment;

import java.util.List;

/**
 * @ClassName CommentService
 * @Description TODO
 * @Author Wrysunny
 * @Date 2020/2/2216:31
 * @Version 1.0
 **/
public interface CommentService {
    List<Comment> selComment(int pageNum);

    int insComment(Comment comment);
}