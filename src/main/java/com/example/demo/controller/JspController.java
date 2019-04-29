package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspController {

    @RequestMapping("/index")
    String index(Model model) {
        model.addAttribute("hello", "hello world");
        return "index";
    }

    @RequestMapping("/purchaseJsp")
    String purchaseJsp() {
        return "purchase";
    }

}
