package com.wangyi.web.pojo.common;


import lombok.Data;

/**
 * @ClassName ResponseMessage
 * @Description TODO 自定义的响应信息
 * @Author Wrysunny
 * @Date 2020/1/1116:09
 * @Version 1.0
 **/
@Data
public class ResponseMessage {
    private String code;
    private String message;
    private String url;
}
