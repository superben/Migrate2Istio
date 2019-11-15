package com.yofc.subject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("")
class MainErrorController implements ErrorController {

    protected static final Logger logger = LoggerFactory.getLogger(MainErrorController.class);

    @Value("${web.errorPage.PAGE404}")
    private String page404;

    @Value("${web.errorPage.PAGE500}")
    private String page500;

    @Value("${web.errorPage.PAGE40X}")
    private String page40x;

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        //获取statusCode:401,404,500
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        logger.error("Request has a error, error code" + statusCode);
        if (statusCode == 401) {
            return page40x;
        } else if (statusCode == 404) {
            logger.error("Request has a error, error code" + statusCode + " forward to " + "/index");
            return page404;
        } else if (statusCode == 403) {
            return page40x;
        } else {
            return page500;
        }

    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}