/**
 * @Author: Liang
 * @Date: 2019/5/18 22:36
 * @Version 1.0
 */
package com.liang.admin_4.service.impl;

import com.github.pagehelper.PageHelper;
import com.liang.admin_4.dao.OrdersDao;
import com.liang.admin_4.domin.Orders;
import com.liang.admin_4.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Liang
 * @date 2019/5/18 22:36
 */
@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersDao ordersDao;

    @Override
    public List<Orders> findAll() throws Exception {
        return ordersDao.findAll();
    }

    @Override
    public Orders findById(String id) throws Exception {
        Orders orders = ordersDao.findById(id);
        return orders;
    }
}
