package com.wangyi.web.dao;

import com.wangyi.web.pojo.Article;

import java.util.List;

/**
 * @ClassName ArticleMapper
 * @Description TODO
 * @Author Wrysunny
 * @Date 2020/1/1520:26
 * @Version 1.0
 **/
public interface ArticleMapper {
    List<Article> selArticle(Article article);

    int insArticle(Article article);

    int updArticle(Article article);

    int delArticle(Integer id);

    int selTotalArticleNum(Article article);
}
