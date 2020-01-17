package com.wangyi.web.compoment.realm;

import com.google.common.base.Splitter;
import com.wangyi.web.pojo.User;
import com.wangyi.web.service.user.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Set;

/**
 * @ClassName UserRealm
 * @Description TODO
 * @Author Wrysunny
 * @Date 2020/1/1315:51
 * @Version 1.0
 **/
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        System.out.println("shouquan");
        Subject subject = SecurityUtils.getSubject();
        User userInfo = (User) subject.getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        String perms = userInfo.getRole().getPerms();
        List<String> perm = Splitter.on(',')
                .omitEmptyStrings()
                .splitToList(perms);
        perm.forEach(info::addStringPermission);
//        Set<String> set = info.getStringPermissions();
//        set.forEach(System.out::println);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        System.out.println("yanzheng");
        //获取传入的username
        String username = (String)authenticationToken.getPrincipal();
        User user = new User();
        user.setUsername(username);
        user = userService.selUserWithAll(user);
        if (user.getUsername().equals(username)) {
            //放入session
            Subject subject = SecurityUtils.getSubject();
            Session session = subject.getSession();
            session.setAttribute("loginuser", user);
            return new SimpleAuthenticationInfo(user,user.getPassword(),getName());
        }
        return null;
    }
}
