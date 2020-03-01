package com.wangyi.web.service.article;

import com.wangyi.web.pojo.Article;
import com.wangyi.web.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ArticleService
 * @Description TODO
 * @Author Wrysunny
 * @Date 2020/1/1520:36
 * @Version 1.0
 **/
public interface ArticleService {
    List<Article> selArticle(Integer pageNum, User user,int pageSize,String type,String value);

    Article selArticleBy(Article article);


    int saveArticle(Article article);

    int delArticle(Integer id);

    int delByList(Integer[] list);

    int getTotalNum(Article article);

    void incArticleClick(Article article);

    Map<String, Article> getArticleIndex(Article article);

    List<Article> getTop5ArticleClick();
}
