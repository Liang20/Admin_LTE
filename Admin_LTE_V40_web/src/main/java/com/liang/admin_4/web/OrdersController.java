/**
 * @Author: Liang
 * @Date: 2019/5/18 22:42
 * @Version 1.0
 */
package com.liang.admin_4.web;

import com.github.pagehelper.PageInfo;
import com.liang.admin_4.domin.Orders;
import com.liang.admin_4.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Liang
 * @date 2019/5/18 22:42
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    //分页
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue =
            "1") int page, @RequestParam(name = "pageSize", required = true, defaultValue = "5")
                                        int pageSize) throws Exception {
        List<Orders> ordersList = ordersService.findAll();

        ModelAndView mv = new ModelAndView();
        mv.setViewName("orders-list");
        mv.addObject("ordersList", ordersList);
        return mv;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(String id) throws Exception {
        Orders orders = ordersService.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("orders-show");
        mv.addObject("orders", orders);
        return mv;
    }
}
