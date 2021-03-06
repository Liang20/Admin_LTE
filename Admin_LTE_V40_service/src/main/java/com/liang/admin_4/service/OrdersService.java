/**
 * @Author: Liang
 * @Date: 2019/5/18 22:35
 * @Version 1.0
 */
package com.liang.admin_4.service;

import com.liang.admin_4.domin.Orders;
import com.liang.admin_4.utils.PageBean;

import java.util.List;

/**
 * @author Liang
 * @date 2019/5/18 22:35
 */
public interface OrdersService {

    PageBean findAll(int page, int pageSize) throws Exception;

    Orders findById(String id) throws Exception;
}
