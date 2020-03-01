package com.wangyi.web.dao;

import com.wangyi.web.compoment.Enum.SelectArticleModel;
import com.wangyi.web.pojo.Article;
import org.apache.ibatis.annotations.Param;

import javax.management.StringValueExp;
import java.util.List;

/**
 * @ClassName ArticleMapper
 * @Description TODO
 * @Author Wrysunny
 * @Date 2020/1/1520:26
 * @Version 1.0
 **/
public interface ArticleMapper {
    List<Article> selArticle(@Param("article") Article article,
                             @Param("flag") SelectArticleModel flag,
                             @Param("type") String type,
                             @Param("value")String value);
    int insArticle(Article article);

    int updArticle(Article article);

    int delArticle(Integer id);

    int selTotalArticleNum(Article article);

    List<Article> getNextArticle(@Param("article") Article article);

    List<Article> getPreArticle(@Param("article") Article article);


}
