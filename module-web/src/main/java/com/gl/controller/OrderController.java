package com.gl.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Package: com.gl.controller
 * Title: OrderController
 * Description: (用一句话描述该文件做什么)
 * Author: gaolei10
 * Date: 2019/9/25 20:35
 * version: v1.0
 */
@RequestMapping("/sys/order")
@RestController
public class OrderController {

    @RequestMapping("query")
    @ResponseBody
    public String query(){
        return "------";
    }
}
