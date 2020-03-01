package com.wangyi.web.Controller.webpage;

import com.github.pagehelper.PageInfo;
import com.wangyi.web.annotation.GetSidebarMessage;
import com.wangyi.web.pojo.Article;
import com.wangyi.web.pojo.User;
import com.wangyi.web.service.article.ArticleService;
import net.sf.jsqlparser.statement.select.First;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ClassName PageController
 * @Description TODO 负责博客展示的Controller
 * @Author Wrysunny
 * @Date 2020/1/1017:22
 * @Version 1.0
 **/
@Controller
public class WebPageController {
    @Autowired
    private ArticleService articleService;

    /*
     * @Author Wrysunny
     * @Description //TODO 负责博客主页的初始化
     * @Date 21:57 2020/1/10
     * @Param []
     * @return java.lang.String
     **/
    @GetSidebarMessage
    @GetMapping({"/index", "/"})
    public String webpageIndex(Model model,
                               @RequestParam(defaultValue = "1") Integer pageNum,
                               @RequestParam(defaultValue="") String type,
                               @RequestParam(defaultValue="最新文章")String value
                               ) {
        List<Article> articleList = articleService.selArticle(pageNum, new User(),5,type,value);
        List<Article> top5ArticleList = articleService.getTop5ArticleClick();
        PageInfo pageInfo = new PageInfo(articleList);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("articleList", articleList);
        model.addAttribute("top5ArticleList",top5ArticleList);
        String href = "/sort/"+type+"/" + value;
        if(type.equals("user")){
            value = articleList.get(0).getWriterbean().getUsername()+"的文章";
        }else if(type.equals("tag")){
            value = value+"标签下的文章";
        }else if(type.equals("keyword")){
            value = "包含"+value+"关键字的文章";
        } else if (type.equals("category")) {
            value = articleList.get(0).getCategorybean().getName() + "栏目下的文章";
        } else {
            href = "/index";
        }
        model.addAttribute("value", value);
        model.addAttribute("currenthref", href);
        return "webpage/index";
    }

    /*
     * @Author Wrysunny
     * @Description //TODO 页面跳转
     * @Date 17:05 2020/2/20
     * @Param [pageNum, model, session]
     * @return java.lang.String
     **/
    @GetSidebarMessage
    @GetMapping("/index/{pageNum}")
    public String webpage(@PathVariable("pageNum") Integer pageNum,
                          Model model) {
        return webpageIndex(model, pageNum, "","最新文章");
    }

    /*
     * @Author Wrysunny
     * @Description //TODO 不同属性下显示不同的文章列表以及页面的跳转
     * @Date 17:06 2020/2/20
     * @Param [keyword, pageNum, model]
     * @return java.lang.String
     **/
    @GetSidebarMessage
    @GetMapping("/sort/{type}/{value}/{pageNum}")
    public String typeShow(@PathVariable("type")String type,
                           @PathVariable("value") String value,
                           @PathVariable("pageNum") Integer pageNum,
                           Model model) {
        return webpageIndex(model, pageNum, type,value);
    }

    /*
     * @Author Wrysunny
     * @Description //TODO 根据关键字查找文章
     * @Date 0:17 2020/2/21
     * @Param [model, pageNum, keyword_value]
     * @return java.lang.String
     **/
    @PostMapping("/sort/keyword/{pageNum}")
    public String keywordShow(Model model,
                              @PathVariable("pageNum")Integer pageNum,
                              String keyword_value){
        return webpageIndex(model, pageNum, "keyword",keyword_value);
    }
}
