package com.wangyi.web.service.article;

import com.github.pagehelper.PageHelper;
import com.wangyi.web.dao.ArticleMapper;
import com.wangyi.web.pojo.Article;
import com.wangyi.web.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ArticleServiceImpl
 * @Description TODO
 * @Author Wrysunny
 * @Date 2020/1/1520:37
 * @Version 1.0
 **/
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<Article> selArticle(Integer pageNum, User user) {
        PageHelper.startPage(pageNum, 10);
        Article article = new Article();
        article.setWriterbean(user);
        return articleMapper.selArticle(article);
    }

    @Override
    public Article selArticleBy(Article article) {
        return articleMapper.selArticle(article).get(0);
    }

    @Override
    public int saveArticle(Article article) {
        if (article.getId() != null) {
            return articleMapper.updArticle(article);
        }else {
            return articleMapper.insArticle(article);
        }

    }

    @Override
    public int delArticle(Integer id) {
        return articleMapper.delArticle(id);
    }

    @Override
    public int delByList(Integer[] list) {
        for (Integer i :
                list) {
            articleMapper.delArticle(i);
        }
        return list.length;
    }

    @Override
    public int getTotalNum(Article article) {
        return articleMapper.selTotalArticleNum(article);
    }
}
