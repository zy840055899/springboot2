package com.example.demo.config;

import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

public class MyRealm extends AuthorizingRealm {

    private static final Logger log = LoggerFactory.getLogger(AuthorizingRealm.class);
    @Resource
    private UserService userService;

    //告诉shiro如何根据获取到的用户信息中的密码和盐值来校验密码
    {
        //设置用于匹配密码的CredentialsMatcher
        HashedCredentialsMatcher hashMatcher = new HashedCredentialsMatcher();
        hashMatcher.setHashAlgorithmName("md5");
        hashMatcher.setHashIterations(1);
        // 不使用盐加密
        hashMatcher.setHashSalted(false);
        this.setCredentialsMatcher(hashMatcher);
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.info("授权");
        String username = (String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = null;
        try {
            authorizationInfo = new SimpleAuthorizationInfo();
            User user = userService.findUserByUserName(username);

            authorizationInfo.addRole("user");
            authorizationInfo.addStringPermission("user:view");
            authorizationInfo.addStringPermission("user:add");
        } catch (Exception e) {
            log.error("授权错误{}", e.getMessage());
            e.printStackTrace();
        }
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        log.info("登录认证..");

        String username = (String) token.getPrincipal();
        User user = userService.findUserByUserName(username);
        if (user == null) {
            throw new UnknownAccountException(); // 没找到帐号
        }

        /*if(Boolean.TRUE.equals(user.getLocked())) {
            throw new LockedAccountException(); //帐号锁定
        }*/

        // 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，
        // 如果觉得人家的不好可以在此判断或自定义实现，这里就是自定义密码校验
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUserName(), //用户名
                user.getPassword(), //密码
                getName()  //realm name
        );

        return authenticationInfo;
    }

}

