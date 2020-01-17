package com.wangyi.web.Controller.manager;

import com.github.pagehelper.PageInfo;
import com.wangyi.web.pojo.Article;
import com.wangyi.web.pojo.Flink;
import com.wangyi.web.pojo.User;
import com.wangyi.web.service.article.ArticleService;
import com.wangyi.web.service.flink.FlinkService;
import com.wangyi.web.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @ClassName ManagerPageController
 * @Description TODO 负责管理首页的Controller
 * @Author Wrysunny
 * @Date 2020/1/1021:55
 * @Version 1.0
 **/
@Controller
@RequestMapping("/manager")
public class IndexController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private FlinkService flinkService;

    /*
     * @Author Wrysunny
     * @Description //TODO 管理页面的首页
     * @Date 12:16 2020/1/11
     * @Param []
     * @return java.lang.String
     **/
    @GetMapping("/index")
    public String managerIndexPage(Model model,
                                   HttpSession session) {
        User user = (User) session.getAttribute("loginuser");
        System.out.println(user);
        Article article = new Article();
        Flink flink = new Flink();
        flink.setWriterbean(user);
        article.setWriterbean(user);
        int articleTotalNum = articleService.getTotalNum(article);
        int flinkTotalNum = flinkService.getTotalNum(flink);
        model.addAttribute("articleTotalNum", articleTotalNum);
        model.addAttribute("flinkTotalNum", flinkTotalNum);
        return "manager/index";
    }



}
