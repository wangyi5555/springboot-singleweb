package com.wangyi.web.service.aop;

import com.wangyi.web.annotation.InClickNum;
import com.wangyi.web.common.IpCommon;
import com.wangyi.web.pojo.Article;
import com.wangyi.web.pojo.LoginLog;
import com.wangyi.web.pojo.User;
import com.wangyi.web.service.article.ArticleService;
import com.wangyi.web.service.loginlog.LoginlogServices;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;


import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName AopService
 * @Description TODO
 * @Author Wrysunny
 * @Date 2020/1/2814:41
 * @Version 1.0
 **/
@Slf4j
@Aspect
@Service
public class AopService {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private LoginlogServices loginlogServices;

    @Pointcut("@annotation(com.wangyi.web.annotation.InClickNum)")
    public void inClickNum(){}

    @Pointcut("@annotation(com.wangyi.web.annotation.GetSidebarMessage)")
    public void getSidebarMessage(){}

    @Pointcut("execution(public * com.wangyi.web.Controller.manager.LoginController.check(..))")
    public void createLoginLog(){}


    /*
     * @Author Wrysunny
     * @Description //TODO 增加文章的点击量
     * @Date 21:58 2020/2/20
     * @Param [pjp, inClickNum1]
     * @return java.lang.Object
     **/
    @Around(value="inClickNum()&&@annotation(inClickNum1)")
    public Object doAroundAdvice(ProceedingJoinPoint pjp,InClickNum inClickNum1) throws Throwable {
        Object proceed = pjp.proceed();
        Object[] args = pjp.getArgs();
        Model arg =(Model)args[1];
        Article article = (Article)arg.getAttribute("article");
        Objects.requireNonNull(article).setClickNum(article.getClickNum()+1);
        articleService.incArticleClick(article);
        return proceed;
    }
    /*
     * @Author Wrysunny
     * @Description //TODO 确保网页侧边栏数据存在
     * @Date 21:58 2020/2/20
     * @Param [pjp]
     * @return java.lang.Object
     **/
    @Around(value = "getSidebarMessage()")
    public Object addMessage(ProceedingJoinPoint pjp) throws Throwable {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        if(session.getAttribute("topClickArticleList")==null||session.getAttribute("date")==null){
            session.setAttribute("date",System.currentTimeMillis());
            List<Article> topClickArticleList = articleService.getTop5ArticleClick();
            session.setAttribute("topClickArticleList",topClickArticleList);
            System.out.println(topClickArticleList.size());
        }
        return pjp.proceed();
    }

    @Around(value = "createLoginLog()")
    public Object addLoginLog(ProceedingJoinPoint pjp) throws Throwable {
        Object proceed =pjp.proceed();
        Object[] args = pjp.getArgs();
        HttpServletRequest request = (HttpServletRequest) args[0];
        User loginuser =(User) request.getSession().getAttribute("loginuser");
        String ip = IpCommon.getRealIp(request);

        LoginLog loginLog = new LoginLog();
        loginLog.setIp(ip);
        if(proceed.equals("redirect:/manager/index")){
            loginLog.setStatus(1);
        }
        loginLog.setUserid(loginuser.getId());
        loginLog.setLasttime(new Timestamp(System.currentTimeMillis()));
        loginuser.getLoginLog().add(loginLog);
        loginlogServices.insLog(loginLog);
        request.getSession().setAttribute("loginlog", loginLog);
        return proceed;
    }

}
