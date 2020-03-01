package com.wangyi.web.service.comment;

import com.github.pagehelper.PageHelper;
import com.wangyi.web.dao.CommentMapper;
import com.wangyi.web.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName CommentServiceImpl
 * @Description TODO
 * @Author Wrysunny
 * @Date 2020/2/2216:32
 * @Version 1.0
 **/
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public List<Comment> selComment(int pageNum) {
        PageHelper.startPage(pageNum, 1);
        return commentMapper.selComment();
    }

    @Override
    public int insComment(Comment comment) {
        return commentMapper.insComment(comment);
    }


}
