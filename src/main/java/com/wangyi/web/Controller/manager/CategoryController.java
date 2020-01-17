package com.wangyi.web.Controller.manager;

import com.wangyi.web.common.CategoryCommon;
import com.wangyi.web.pojo.Category;
import com.wangyi.web.compoment.common.ResponseMessage;
import com.wangyi.web.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName CategoryController
 * @Description TODO 负责标签的controller
 * @Author Wrysunny
 * @Date 2020/1/1119:50
 * @Version 1.0
 **/
@Controller
@RequestMapping("/manager")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /*
     * @Author Wrysunny
     * @Description //TODO 返回初始化的标签页面
     * @Date 13:29 2020/1/12
     * @Param [model]
     * @return java.lang.String
     **/
    @GetMapping("/category")
    public String categoryPage(Model model) {
        List<Category> categoryList = categoryService.selCategory(new Category());
        List<Category> categoryOption = CategoryCommon.getOption(categoryList);
        model.addAttribute("categoryOption", categoryOption);
        model.addAttribute("categoryList", categoryList);
        return "manager/category";
    }

    /*
     * @Author Wrysunny
     * @Description //TODO 新增一条标签记录
     * @Date 13:29 2020/1/12
     * @Param [category]
     * @return java.lang.String
     **/
    @PostMapping("/category/add")
    public String addCategory(Category category) {
        categoryService.saveCategory(category);
        return "redirect:/manager/category";
    }



    /*
     * @Author Wrysunny
     * @Description //TODO 跳转到标签修改的页面
     * @Date 13:30 2020/1/12
     * @Param [id, model]
     * @return java.lang.String
     **/
    @GetMapping("/category/updatepage/{id}")
    public String updatePage(@PathVariable("id") Integer id,
                             Model model) {
        Category category = new Category();
        category.setId(id);
        model.addAttribute("selectCategory", categoryService.selCategory(category).get(0));
        List<Category> categoryList = categoryService.selCategory(new Category());
        List<Category> categoryOption = CategoryCommon.getOption(categoryList);
        model.addAttribute("categoryOption", categoryOption);
        return "manager/update-category";
    }

    /*
     * @Author Wrysunny
     * @Description //TODO 修改指定标签的值
     * @Date 13:31 2020/1/12
     * @Param [category]
     * @return java.lang.String
     **/
    @PutMapping("/category/update")
    public String updateCategory(Category category) {
        categoryService.saveCategory(category);
        return "redirect:/manager/category";
    }

    /*
     * @Author Wrysunny
     * @Description //TODO 删除指定的标签记录
     * @Date 13:30 2020/1/12
     * @Param [category]
     * @return com.wangyi.web.pojo.common.ResponseMessage
     **/
    @DeleteMapping("/category/delete")
    @ResponseBody
    public ResponseMessage deleteCategory(Category category) {
        categoryService.delCategory(category);
        return new ResponseMessage();
    }


}
