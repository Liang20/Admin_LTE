/**
 * @Author: Liang
 * @Date: 2019/5/18 21:37
 * @Version 1.0
 */
package com.liang.admin_4.service;

import com.liang.admin_4.domin.Product;
import com.liang.admin_4.utils.PageBean;

import java.util.List;

/**
 * @author Liang
 * @date 2019/5/18 21:37
 */
public interface ProductService {

    //查询所有商品信息
    public List<Product> findAll() throws Exception;
    //查询所有商品信息
    public PageBean findAll(int page, int pageSize) throws Exception;

    //添加商品
    void save(Product product) throws Exception;


}
