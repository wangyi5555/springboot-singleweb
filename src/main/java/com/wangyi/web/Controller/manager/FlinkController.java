package com.wangyi.web.Controller.manager;

import com.github.pagehelper.PageInfo;
import com.wangyi.web.pojo.Flink;
import com.wangyi.web.pojo.User;
import com.wangyi.web.pojo.common.ResponseMessage;
import com.wangyi.web.service.flink.FlinkService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;

/**
 * @ClassName FlinkController
 * @Description TODO 负责友情链接的Controller
 * @Author Wrysunny
 * @Date 2020/1/1212:12
 * @Version 1.0
 **/
@Controller
@RequestMapping("/manager")
public class FlinkController {
    @Autowired
    private FlinkService flinkService;

    /*
     * @Author Wrysunny
     * @Description //TODO 返回标签管理的首页
     * @Date 13:35 2020/1/12
     * @Param [pageNum, model]
     * @return java.lang.String
     **/
    @GetMapping("/flink/{pageNum}")
    public String flinkPage(@PathVariable("pageNum") Integer pageNum,
                            Model model) {
        if (pageNum != null) {
            List<Flink> flinkList = flinkService.selAllFlink(pageNum);
            PageInfo<Flink> pageInfo = new PageInfo<>(flinkList);
            model.addAttribute("flinkList", flinkList);
            model.addAttribute("pageInfo", pageInfo);
        }
        return "manager/flink";
    }

    @GetMapping("/flink/addpage")
    public String addLinkPage(Model model) {
        model.addAttribute("currentDate", new Date());
        return "manager/add-flink";
    }

    @PostMapping("/flink/addflink")
    public String addLink(Flink flink) {
//        System.out.println(flink);
        flinkService.saveFlink(flink);
        return "redirect:/manager/flink/1";
    }

    @GetMapping("/flink/updatepage/{id}")
    public String updatePage(Model model,
                             @PathVariable("id") Integer id) {
        Flink flink = new Flink();
        flink.setId(id);
        model.addAttribute("flink", flinkService.selFlinkByID(flink));
        model.addAttribute("currentDate", new Date());
        return "manager/update-flink";
    }

    @PutMapping("/flink/update")
    public String updateFlink(Flink flink) {
        flinkService.saveFlink(flink);
        return "redirect:/manager/flink/1";
    }

    @DeleteMapping("/flink/delete")
    @ResponseBody
    public ResponseMessage deleteFlink(Integer id) {
        flinkService.delFilnk(id);
        return new ResponseMessage();
    }

    @DeleteMapping("/flink/delList")
    public String delList(@RequestParam(value = "checkbox[]",required = false) Integer[] checkbox) {
        flinkService.delByList(checkbox);
        return "redirect:/manager/flink/1";
    }
}
