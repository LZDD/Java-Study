package com.lzdd.controller;

import com.lzdd.annotation.AnnotationDemo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Created by fei.tang@hand-china.com on 2018/1/27.
 * @description 内容交易平台
 */
@AnnotationDemo(value = "DemoController Class")
@RestController
@RequestMapping(value = "/api")
public class DemoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoController.class);

    @RequestMapping("/index.do")
    @AnnotationDemo(value = "/api/index")
    public String getIndex(){
        LOGGER.debug("Here is getIndex method");
        System.out.println("Here is getIndex method");
        return "getIndex";
    }

    @RequestMapping("/test.do")
    @AnnotationDemo(value = "/api/test")
    public String getTest(){
        LOGGER.debug("Here is getTest method");
        System.out.println("Here is getTest method");
        return "getTest";
    }


    public String test(@PathVariable() String name,@RequestParam String age){
        return "sdf";
    }
}
