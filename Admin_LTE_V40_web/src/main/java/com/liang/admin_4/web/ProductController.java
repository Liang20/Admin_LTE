/**
 * @Author: Liang
 * @Date: 2019/5/18 21:33
 * @Version 1.0
 */
package com.liang.admin_4.web;

import com.liang.admin_4.domin.Product;
import com.liang.admin_4.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Liang
 * @date 2019/5/18 21:33
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    //产品添加
    @RequestMapping("/save.do")
    public String save(Product product) throws Exception {
        productService.save(product);
        return "redirect:findAll.do";
    }
}
