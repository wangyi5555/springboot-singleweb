package com.wangyi.web.Controller;

import com.wangyi.web.compoment.common.ResponseMessage;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @ClassName BaseController
 * @Description TODO controller的基类，用于完成一些公用方法
 * @Author Wrysunny
 * @Date 2020/1/1119:17
 * @Version 1.0
 **/
@Controller
public class BaseController {
    @PostMapping("/image/upload")
    @ResponseBody
    public ResponseMessage uploadImage(@RequestParam("file")MultipartFile file) {

        String filename = file.getOriginalFilename();
        //目录名
        String filepath = new SimpleDateFormat("yyyyMMdd").format(new Date());
        //文件名
        String fileName = new Date().getTime() + "" + (int) ((Math.random() * 9 + 1) * 100000);
        //后缀名
        String suffix = filename.substring(filename.lastIndexOf('.'));

        String url = "/upload/image/" + filepath + "/" + fileName + suffix;

        try {
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setUrl(url);
        return responseMessage;
    }

}
