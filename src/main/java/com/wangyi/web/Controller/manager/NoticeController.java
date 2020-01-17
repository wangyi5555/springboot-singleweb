package com.wangyi.web.Controller.manager;

import com.github.pagehelper.PageInfo;
import com.wangyi.web.pojo.Notice;
import com.wangyi.web.compoment.common.ResponseMessage;
import com.wangyi.web.service.notice.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @ClassName NoticeController
 * @Description TODO
 * @Author Wrysunny
 * @Date 2020/1/1612:13
 * @Version 1.0
 **/
@Controller
@RequestMapping("/manager")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @GetMapping("/notice/{pageNum}")
    public String noticePage(@PathVariable("pageNum") Integer pageNum,
                             Model model) {
        List<Notice> noticeList = noticeService.selNotice(pageNum);
        PageInfo<Notice> pageInfo = new PageInfo<>(noticeList);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("noticeList", noticeList);
        return "manager/notice";
    }

    @GetMapping("/notice/addpage")
    public String addNoticePage(Model model) {
        model.addAttribute("currentDate", new Date());
        return "manager/add-notice";
    }

    @PostMapping("/notice/add")
    public String addNotice(Notice notice) {
        noticeService.saveNotice(notice);
        return "redirect:/manager/notice/1";
    }

    @GetMapping("/notice/updatepage/{id}")
    public String updatePage(@PathVariable("id") Integer id,
                             Model model) {
        Notice notice = new Notice();
        notice.setId(id);
        notice = noticeService.selNoticeBy(notice);
        model.addAttribute("currentDate", new Date());
        model.addAttribute("notice", notice);
        return "manager/update-notice";
    }

    @PutMapping("/notice/update")
    public String updateNotice(Notice notice) {
        noticeService.saveNotice(notice);
        return "redirect:/manager/notice/1";
    }

    @DeleteMapping("/notice/delete")
    @ResponseBody
    public ResponseMessage deleteNotice(Integer id) {
        noticeService.delNotice(id);
        return new ResponseMessage();
    }

    @DeleteMapping("/notice/delList")
    public String delList(@RequestParam(value = "checkbox[]",required = false) Integer[] checkbox) {
        noticeService.delByList(checkbox);
        return "redirect:/manager/notice/1";
    }
}
