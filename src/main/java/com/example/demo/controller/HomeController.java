package com.example.demo.controller;

import com.example.demo.pojo.Result;
import com.example.demo.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class HomeController {
    @Resource
    private LoginService loginService;

    @RequestMapping({"/", "/index"})
    public String index() {
        return "index";
    }

    @RequestMapping("/403")
    public String unauthorizedRole() {
        System.out.println("------没有权限-------");
        return "403";
    }

    @GetMapping("login")
    public String toLogin(Map<String, Object> map, HttpServletRequest request) {
        loginService.logout();
        return "login";
    }

    @PostMapping("login")
    public String login(Map<String, Object> map, HttpServletRequest request) throws Exception {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        Result loginResult = loginService.login(userName, password);
        if (loginResult.isLoginR()) {
            return "index";
        } else {
            map.put("msg", loginResult.getResultStr());
            map.put("userName", userName);
            return "login";
        }
    }

    @RequestMapping("/logout")
    public String logOut(HttpSession session) {
        loginService.logout();
        return "login";
    }
}