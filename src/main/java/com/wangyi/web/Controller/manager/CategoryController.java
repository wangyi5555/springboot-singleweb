package com.wangyi.web.Controller.manager;

import com.wangyi.web.common.CategoryCommon;
import com.wangyi.web.pojo.Category;
import com.wangyi.web.pojo.User;
import com.wangyi.web.pojo.common.ResponseMessage;
import com.wangyi.web.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName CategoryController
 * @Description TODO
 * @Author Wrysunny
 * @Date 2020/1/1119:50
 * @Version 1.0
 **/
@Controller
@RequestMapping("/manager")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public String categoryPage(Model model) {
        List<Category> categoryList = categoryService.selCategory(new Category());
        List<Category> categoryOption = CategoryCommon.getOption(categoryList);
        model.addAttribute("categoryOption", categoryOption);
        model.addAttribute("categoryList", categoryList);
        return "manager/category";
    }

    @PostMapping("/category/add")
    public String addCategory(Category category) {
        categoryService.saveCategory(category);
        return "redirect:/manager/category";
    }

    @DeleteMapping("/category/delete")
    @ResponseBody
    public ResponseMessage deleteCategory(Category category) {
        categoryService.delCategory(category);
        return new ResponseMessage();
    }

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

    @PutMapping("/category/update")
    public String updateCategory(Category category) {
        categoryService.saveCategory(category);
        return "redirect:/manager/category";
    }

}
