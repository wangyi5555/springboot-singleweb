package com.wangyi.web.Controller;

import com.baidu.ueditor.ActionEnter;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
/*
 * @Author Wrysunny
 * @Description //TODO ueditor读取配置文件的控制器
 * @Date 20:27 2020/1/15
 * @Param
 * @return
 **/
@Controller
public class ServerController {
    @RequestMapping(value="/config")
    public void config(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        ///js/ueditor/jsp
        String rootPath = ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static";
//        String rootPath = ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static/images";
        try {
            response.setCharacterEncoding("UTF-8");
            String exec = new ActionEnter(request, rootPath).exec();
            System.out.println(rootPath);
            System.out.println(exec);
            PrintWriter writer = response.getWriter();
            writer.write(new ActionEnter( request, rootPath ).exec());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
