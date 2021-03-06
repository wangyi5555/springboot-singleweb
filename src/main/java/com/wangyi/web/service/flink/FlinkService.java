package com.wangyi.web.service.flink;

import com.wangyi.web.pojo.Flink;
import com.wangyi.web.pojo.User;

import java.util.List;

/**
 * @ClassName FlinkService
 * @Description TODO
 * @Author Wrysunny
 * @Date 2020/1/1212:11
 * @Version 1.0
 **/
public interface FlinkService {
    List<Flink> selAllFlink(int pageNum, User user);

    Flink selFlinkByID(Flink flink);

    int saveFlink(Flink flink);

    int delFilnk(int id);

    int delByList(Integer[] list);

    int getTotalNum(Flink flink);
}
