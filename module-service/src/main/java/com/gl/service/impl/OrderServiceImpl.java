package com.gl.service.impl;

import com.gl.common.util.SequenceUtil;
import com.gl.dao.OrderDao;
import com.gl.domain.Order;
import com.gl.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Package: com.gl.service.impl
 * Title: OrderServiceImpl
 * Description: (用一句话描述该文件做什么)
 * Author: gaolei10
 * Date: 2019/9/27 17:36
 * version: v1.0
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private SequenceUtil sequenceUtil;

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor = Exception.class)
    public Integer insert(Order order) {
        if(order.getId() == null){
            order.setId(sequenceUtil.get("T_ORDER"));
        }
        Integer result = orderDao.insert(order);
        int i = 1/0;
        return result;
    }
}
