package com.wangyi.web.Controller.webpage;

import com.wangyi.web.annotation.GetSidebarMessage;
import com.wangyi.web.annotation.InClickNum;
import com.wangyi.web.common.ArticleCommon;
import com.wangyi.web.common.CommentCommon;
import com.wangyi.web.pojo.Article;
import com.wangyi.web.pojo.Comment;
import com.wangyi.web.service.article.ArticleService;
import com.wangyi.web.service.comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Timestamp;
import java.util.Map;

/**
 * @ClassName ContentController
 * @Description TODO
 * @Author Wrysunny
 * @Date 2020/1/1814:10
 * @Version 1.0
 **/
@Controller
public class ContentController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private CommentService commentService;


    @InClickNum
    @GetSidebarMessage
    @GetMapping("/content/{id}")
    public String contentPage(@PathVariable("id") Integer id,
                              Model model) {
        Article article = new Article();
        article.setId(id);
        article = articleService.selArticleBy(article);
        System.out.println(article.getCommentList()+"--------------------------");
        article.setCommentList(CommentCommon.sortByTime(article.getCommentList()));
        Map<String, Article> articleIndex = articleService.getArticleIndex(article);
        model.addAttribute("article", article);
        if(articleIndex.containsKey("pre")){
            model.addAttribute("pre", articleIndex.get("pre"));
        }
        if(articleIndex.containsKey("next")){
            model.addAttribute("next", articleIndex.get("next"));
        }

        return "webpage/content";
    }

    @PostMapping("/content/addComment")
    public String addComment(Comment comment, Model model) {
        comment.setDate(new Timestamp(System.currentTimeMillis()));
        commentService.insComment(comment);
        return "redirect:/content/"+comment.getBelong_id();
    }

}
