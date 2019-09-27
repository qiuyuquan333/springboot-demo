package com.qyq.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/index")
    public String index(){
        logger.info("访问主页{} and {}","QYQ","YXY");
        return "index";
    }

}
