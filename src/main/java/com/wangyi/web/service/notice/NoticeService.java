package com.wangyi.web.service.notice;

import com.wangyi.web.pojo.Notice;

import java.util.List;

/**
 * @ClassName NoticeService
 * @Description TODO
 * @Author Wrysunny
 * @Date 2020/1/1621:58
 * @Version 1.0
 **/
public interface NoticeService {
    List<Notice> selNotice(Integer pageNum);

    Notice selNoticeBy(Notice notice);

    int saveNotice(Notice notice);

    int delNotice(Integer id);

    int delByList(Integer[] list);
}
