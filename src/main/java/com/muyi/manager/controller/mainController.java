package com.muyi.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * description： index页面
 * Create By  ： sena104
 * Create Time： Created in 2021-06-07 15:08
 */
@Controller
public class mainController {

    @RequestMapping("/index")
    public String main() {
        return "main";
    }
}
