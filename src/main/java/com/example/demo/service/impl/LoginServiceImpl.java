package com.example.demo.service.impl;

import com.example.demo.pojo.Result;
import com.example.demo.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Override
    public Result login(String userName, String password) {
        Result loginResult = new Result();
        if (userName == null || userName.isEmpty()) {
            loginResult.setLoginR(false);
            loginResult.setResultStr("用户名为空");
            return loginResult;
        }
        String msg = "";
        // 1、获取Subject实例对象
        Subject subject = SecurityUtils.getSubject();

//        // 2、判断当前用户是否登录
//        if (subject.isAuthenticated() == false) {
//
//        }

        // 3、将用户名和密码封装到UsernamePasswordToken
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);

        // 4、认证
        try {
            subject.login(token);// 传到MyAuthorizingRealm类中的方法进行认证★
            Session session = subject.getSession();
            session.setAttribute("userName", userName);
            loginResult.setLoginR(true);
            return loginResult;
            //return "/index";
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            msg = "UnknownAccountException -- > 账号不存在：";
        } catch (IncorrectCredentialsException e) {
            msg = "IncorrectCredentialsException -- > 密码不正确：";
        } catch (AuthenticationException e) {
            e.printStackTrace();
            msg = "用户验证失败";
        }

        loginResult.setLoginR(false);
        loginResult.setResultStr(msg);

        return loginResult;
    }

    @Override
    public void logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }
}
