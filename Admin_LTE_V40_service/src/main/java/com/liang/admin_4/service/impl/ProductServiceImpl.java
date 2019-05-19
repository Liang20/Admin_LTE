/**
 * @Author: Liang
 * @Date: 2019/5/18 21:38
 * @Version 1.0
 */
package com.liang.admin_4.service.impl;

import com.github.pagehelper.PageHelper;
import com.liang.admin_4.dao.ProductDao;
import com.liang.admin_4.domin.Product;
import com.liang.admin_4.service.ProductService;
import com.liang.admin_4.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Liang
 * @date 2019/5/18 21:38
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductDao productDao;


    //添加商品
    @Override
    public void save(Product product) {
        productDao.save(product);
    }

    //查询所有商品
   /* @Override
    public List<Product> findAll() throws Exception{
        return productDao.findAll();
    }*/
    //查询所有商品
    @Override
    public PageBean findAll(int page,int pageSize ) throws Exception{
        int totalcount = productDao.getTotalCount();
        PageBean pageBean = new PageBean(page,totalcount,pageSize);
        List<Product>  productList = productDao.getPageList(pageBean.getStart(),pageSize);
        pageBean.setList(productList);
        return pageBean;
    }
}
