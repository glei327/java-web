package com.gl.test;

import com.gl.WebApplication;
import com.gl.domain.Order;
import com.gl.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Package: com.gl.test
 * Title: OrderServiceTest
 * Description: (用一句话描述该文件做什么)
 * Author: gaolei10
 * Date: 2019/9/27 17:39
 * version: v1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplication.class)
public class OrderServiceTest {

    @Resource
    private OrderService orderService;

    @Test
    public void testInsert(){
        Order order = new Order();
        orderService.insert(order);
    }
}
