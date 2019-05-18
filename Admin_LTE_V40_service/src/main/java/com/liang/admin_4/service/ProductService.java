/**
 * @Author: Liang
 * @Date: 2019/5/18 21:37
 * @Version 1.0
 */
package com.liang.admin_4.service;

import com.liang.admin_4.domin.Product;

import java.util.List;

/**
 * @author Liang
 * @date 2019/5/18 21:37
 */
public interface ProductService {

    public List<Product> findAll() throws Exception;

    void save(Product product) throws Exception;


}
