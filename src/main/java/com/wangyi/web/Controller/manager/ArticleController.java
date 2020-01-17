package com.wangyi.web.Controller.manager;

import com.github.pagehelper.PageInfo;
import com.wangyi.web.common.CategoryCommon;
import com.wangyi.web.pojo.Article;
import com.wangyi.web.pojo.Category;
import com.wangyi.web.compoment.common.ResponseMessage;
import com.wangyi.web.pojo.User;
import com.wangyi.web.service.article.ArticleService;
import com.wangyi.web.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @ClassName ArticleController
 * @Description TODO
 * @Author Wrysunny
 * @Date 2020/1/1319:38
 * @Version 1.0
 **/
@Controller
@RequestMapping("/manager")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private CategoryService categoryService;

    /*
     * @Author Wrysunny
     * @Description //TODO 根据当前用户来查询特定的文章
     * @Date 21:10 2020/1/17
     * @Param [pageNum, model]
     * @return java.lang.String
     **/
    @GetMapping("/article/{pageNum}")
    public String articleIndex(@PathVariable("pageNum") Integer pageNum,
                               Model model,
                               HttpSession session) {
        User user = (User) session.getAttribute("loginuser");
        List<Article> articleList = articleService.selArticle(pageNum,user);
        PageInfo<Article> pageInfo = new PageInfo<>(articleList);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("articleList", articleList);
        return "manager/article";
    }

    @GetMapping("/article/addpage")
    public String addArticleIndex(Model model) {
        List<Category> categoryList = CategoryCommon.getOption(categoryService.selCategory(new Category()));
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("currentDate", new Date());
        return "manager/add-article";
    }

    @PostMapping("/article/add")
    public String addArticle(Article article,
                             HttpSession session) {
        User user = (User) session.getAttribute("loginuser");
        article.setWriterbean(user);
        System.out.println(article);
        articleService.saveArticle(article);
        return "redirect:/manager/article/1";
    }

    @GetMapping("/article/updatepage/{id}")
    public String updateArticlePage(@PathVariable("id") Integer id,
                                    Model model) {
        Article article = new Article();
        article.setId(id);
        article = articleService.selArticleBy(article);
        System.out.println(article.getContent());
        List<Category> categoryList = CategoryCommon.getOption(categoryService.selCategory(new Category()));
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("article", article);
        model.addAttribute("currentDate", new Date());
        return "manager/update-article";
    }

    @PutMapping("/article/update")
    public String updateArticle(Article article){
        articleService.saveArticle(article);
        return "redirect:/manager/article/1";
    }


    @DeleteMapping("/article/delete")
    @ResponseBody
    public ResponseMessage deleteArticle(@RequestParam("id")Integer id){
        articleService.delArticle(id);
        return new ResponseMessage();
    }
    @DeleteMapping("/article/delList")
    public String delList(@RequestParam(value = "checkbox[]",required = false) Integer[] checkbox) {
        articleService.delByList(checkbox);
        return "redirect:/manager/article/1";
    }
}
