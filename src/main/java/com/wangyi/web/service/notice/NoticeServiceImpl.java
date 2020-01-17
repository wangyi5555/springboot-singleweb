package com.wangyi.web.service.notice;

import com.github.pagehelper.PageHelper;
import com.wangyi.web.dao.NoticeMapper;
import com.wangyi.web.pojo.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName NoticeServiceImpl
 * @Description TODO
 * @Author Wrysunny
 * @Date 2020/1/1621:58
 * @Version 1.0
 **/
@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public List<Notice> selNotice(Integer pageNum) {
        PageHelper.startPage(pageNum, 1);
        return noticeMapper.selNotice(new Notice());
    }

    @Override
    public Notice selNoticeBy(Notice notice) {
        return noticeMapper.selNotice(notice).get(0);
    }

    @Override
    public int saveNotice(Notice notice) {
        if(notice.getId()!=null){
            return noticeMapper.updNotice(notice);
        }else{
            return noticeMapper.insNotice(notice);
        }
    }

    @Override
    public int delNotice(Integer id) {
        return noticeMapper.delNotice(id);
    }

    @Override
    public int delByList(Integer[] list) {
        for (Integer i :
                list) {
            noticeMapper.delNotice(i);
        }
        return list.length;
    }

}
