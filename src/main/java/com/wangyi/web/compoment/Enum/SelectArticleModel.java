package com.wangyi.web.compoment.Enum;

import lombok.Data;

/**
 * @ClassName SelectArticleModel
 * @Description TODO 文章查询的模式
 * @Author Wrysunny
 * @Date 2020/2/2012:07
 * @Version 1.0
 **/

public enum SelectArticleModel {
    _NORMAL(0),_BYDATE(1),_BYCLICK(2);
    //表顺序查询，按时间排序，按点击数排序

    Integer flag;

    SelectArticleModel(int i){
        this.flag = i;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}
