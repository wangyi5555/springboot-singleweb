package com.wangyi.web.compoment.common;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName ResponseMessage
 * @Description TODO 自定义的响应信息
 * @Author Wrysunny
 * @Date 2020/1/1116:09
 * @Version 1.0
 **/
@Data
@Component
public class ResponseMessage {
    private String code;
    private String message;
    private String url;
}
