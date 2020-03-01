package com.wangyi.web;

import com.wangyi.web.common.ArticleCommon;
import com.wangyi.web.common.CategoryCommon;
import com.wangyi.web.compoment.Enum.SelectArticleModel;
import com.wangyi.web.dao.*;
import com.wangyi.web.pojo.*;
import com.wangyi.web.service.category.CategoryService;
import com.wangyi.web.service.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class WebApplicationTests {


    @Autowired
    private ArticleMapper articleMapper;

    @Test
    void contextLoads() {
//        List<Article> list = articleMapper.selArticle(new Article(), SelectArticleModel._BYCLICK);
//        ArticleCommon.getArticleIndex(list);
//        System.out.println(SelectArticleModel._BYCLICK.getFlag());

        List<Article> list = articleMapper.selArticle(new Article(), SelectArticleModel._BYCLICK, "","");
        System.out.println(list);
    }


}
