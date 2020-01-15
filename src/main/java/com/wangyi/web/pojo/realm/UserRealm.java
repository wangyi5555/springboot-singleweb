package com.wangyi.web.pojo.realm;

import com.wangyi.web.pojo.User;
import com.wangyi.web.service.user.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLOutput;

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
        System.out.println("shouquan");
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("yanzheng");
        String username = (String)authenticationToken.getPrincipal();
        User user = new User();
        user.setUsername(username);
        user = userService.selUserByID(user);
        if (!user.getUsername().equals(username)) {
            return null;
        }
        return new SimpleAuthenticationInfo("",user.getPassword(),getName());
    }
}
