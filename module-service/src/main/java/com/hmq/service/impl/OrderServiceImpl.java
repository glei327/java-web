package com.hmq.service.impl;

import com.hmq.common.util.SequenceUtil;
import com.hmq.dao.OrderDao;
import com.hmq.domain.Order;
import com.hmq.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Package: com.hmq.service.impl
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
        return result;
    }
}
