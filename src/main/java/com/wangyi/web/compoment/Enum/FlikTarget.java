package com.wangyi.web.compoment.Enum;

import lombok.Data;

/**
 * @ClassName FlikTarget
 * @Description TODO
 * @Author Wrysunny
 * @Date 2020/1/1211:38
 * @Version 1.0
 **/
public enum FlikTarget {
    _BLANK("_blank"), _SELF("_self"), _TOP("_top");


    private String target;

    FlikTarget(String target) {
        this.target = target;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
