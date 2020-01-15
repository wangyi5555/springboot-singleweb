package com.wangyi.web.dao;


import com.wangyi.web.pojo.Flink;

import java.util.List;

/**
 * @ClassName FlinkMapper
 * @Description TODO
 * @Author Wrysunny
 * js 2020/1/1211:59
 * @Version 1.0
 **/
public interface FlinkMapper {
    List<Flink> selFlink(Flink flink);

    int insFlink(Flink flink);

    int updFlink(Flink flink);

    int delFlink(int id);

}
