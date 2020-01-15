package com.wangyi.web.service.article;

import com.wangyi.web.pojo.Article;

import java.util.List;

/**
 * @ClassName ArticleService
 * @Description TODO
 * @Author Wrysunny
 * @Date 2020/1/1520:36
 * @Version 1.0
 **/
public interface ArticleService {
    List<Article> selArticle(Integer pageNum);

    Article selArticleBy(Article article);


    int saveArticle(Article article);

    int delArticle(Integer id);

    int delByList(Integer[] list);
}
