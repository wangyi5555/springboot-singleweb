package com.wangyi.web.dao;

import com.wangyi.web.pojo.Notice;

import java.util.List;

/**
 * @ClassName NoticeMapper
 * @Description TODO
 * @Author Wrysunny
 * @Date 2020/1/1621:21
 * @Version 1.0
 **/
public interface NoticeMapper {
    List<Notice> selNotice(Notice notice);

    int insNotice(Notice notice);

    int updNotice(Notice notice);


    int delNotice(Integer id);
}
