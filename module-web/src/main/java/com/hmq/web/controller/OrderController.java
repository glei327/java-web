package com.hmq.web.controller;

import com.hmq.domain.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Package: com.hmq.web.controller
 * Title: OrderController
 * Description: (用一句话描述该文件做什么)
 * Author: gaolei10
 * Date: 2019/9/25 20:35
 * version: v1.0
 */
@RequestMapping("/sys/order")
@RestController
@Slf4j
public class OrderController {

    @RequestMapping("queryData")
    @ResponseBody
    public Map<String,Object> queryData(){
        log.error("-----");
        Map<String,Object> result = new HashMap<String,Object>();
        Order order = new Order();
        result.put("success",true);
        order.setCreated(new Date());
        order.setId(1l);
        result.put("data",order);
        return result;
    }


    @RequestMapping(value = "/list")
    public ModelAndView list(HttpServletRequest request) {
        Order order = new Order();
        order.setCreated(new Date());
        order.setId(1l);
        ModelAndView mv = new ModelAndView();
        mv.addObject("order", order);
        mv.setViewName("/order/orderList.html");
        return mv;
    }
}
