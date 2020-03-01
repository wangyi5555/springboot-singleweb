package com.wangyi.web.Controller.webpage;

import com.github.pagehelper.PageInfo;
import com.wangyi.web.annotation.GetSidebarMessage;
import com.wangyi.web.common.CommentCommon;
import com.wangyi.web.pojo.Comment;
import com.wangyi.web.service.comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.List;

/**
 * @ClassName ReaderWall
 * @Description TODO
 * @Author Wrysunny
 * @Date 2020/1/1814:33
 * @Version 1.0
 **/
@Controller
public class ReaderWallController {
    @Autowired
    private CommentService commentService;
    @GetSidebarMessage
    @GetMapping("/readerWall")
    public String readerwallPage(Model model,
                                 @RequestParam(defaultValue = "1") Integer pageNum){
        List<Comment> list = commentService.selComment(pageNum);
        PageInfo pageInfo = new PageInfo(list);
        System.out.println(pageInfo);
        list = CommentCommon.sortByTime(list);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("list", list);
        model.addAttribute("currenthref", "/readerWall");
        return "webpage/readerWall";
    }

    @GetSidebarMessage
    @GetMapping("/readerWall/{pageNum}")
    public String readerWall(@PathVariable("pageNum") Integer pageNum,
                             Model model){
        return readerwallPage(model, pageNum);
    }

    @PostMapping("/readerWall/addComment")
    public String addComment(Comment comment,Model model) {
        comment.setDate(new Timestamp(System.currentTimeMillis()));
        commentService.insComment(comment);
        return readerwallPage(model, 1);
    }
}
