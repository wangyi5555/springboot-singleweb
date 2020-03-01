package com.wangyi.web.service.article;

import com.github.pagehelper.PageHelper;
import com.wangyi.web.compoment.Enum.SelectArticleModel;
import com.wangyi.web.dao.ArticleMapper;
import com.wangyi.web.pojo.Article;
import com.wangyi.web.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /*
     * @Author Wrysunny
     * @Description //TODO 首页查找所有的文章
     * @Date 11:55 2020/2/20
     * @Param [pageNum, user]
     * @return java.util.List<com.wangyi.web.pojo.Article>
     **/
    @Override
    public List<Article> selArticle(Integer pageNum, User user,int pageSize,String type,String value) {
        PageHelper.startPage(pageNum, pageSize);
        Article article = new Article();
        article.setWriterbean(user);
        return articleMapper.selArticle(article, SelectArticleModel._BYDATE,type,value);
    }

    @Override
    public Article selArticleBy(Article article) {
        return articleMapper.selArticle(article,SelectArticleModel._NORMAL,"", "").get(0);
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

    /*
     * @Author Wrysunny
     * @Description //TODO 获取文章总数
     * @Date 17:31 2020/2/20
     * @Param [article]
     * @return int
     **/
    @Override
    public int getTotalNum(Article article) {
        return articleMapper.selTotalArticleNum(article);
    }

    /*
     * @Author Wrysunny
     * @Description //TODO 增加文章点击量
     * @Date 15:42 2020/2/20
     * @Param [article]
     * @return void
     **/
    @Async
    @Override
    public void incArticleClick(Article article) {
        articleMapper.updArticle(article);
    }

    /*
     * @Author Wrysunny
     * @Description //TODO 获取文章前后篇
     * @Date 17:31 2020/2/20
     * @Param [article]
     * @return java.util.Map<java.lang.String,com.wangyi.web.pojo.Article>
     **/
    @Override
    public Map<String, Article> getArticleIndex(Article article) {
        Map<String, Article> result = new HashMap<>();
        List<Article> preArticle = articleMapper.getPreArticle(article);
        List<Article> nextArticle = articleMapper.getNextArticle(article);
        if(preArticle.size()>0){
            result.put("pre", preArticle.get(0));
        }
        if(nextArticle.size()>0){
            result.put("next", nextArticle.get(0));
        }
        return result;
    }

    /*
     * @Author Wrysunny
     * @Description //TODO 获得点击量前五的文章
     * @Date 17:32 2020/2/20
     * @Param []
     * @return java.util.List<com.wangyi.web.pojo.Article>
     **/
    @Override
    public List<Article> getTop5ArticleClick() {
        return articleMapper.selArticle(new Article(), SelectArticleModel._BYCLICK, "","");
    }


}
