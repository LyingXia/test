package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * created by xiapf on 2018/7/4
 */
@Controller
@RequestMapping("/demo")
public class MyController {
    @RequestMapping("/welcome")
    public String welcome(){
        return "/welcome";
    }
}
