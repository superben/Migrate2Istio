package com.yofc.subject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("")
public class PageController {

    @GetMapping("/index")
    String index(HttpServletRequest request) {
        System.out.println("==================test============userId:" + request.getParameter("userId"));
        return "index";
    }

    @GetMapping("")
    String sample(HttpServletRequest request) {
        return "index";
    }
}
