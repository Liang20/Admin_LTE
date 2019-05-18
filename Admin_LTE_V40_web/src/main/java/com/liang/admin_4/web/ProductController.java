/**
 * @Author: Liang
 * @Date: 2019/5/18 21:33
 * @Version 1.0
 */
package com.liang.admin_4.web;

import com.github.pagehelper.PageInfo;
import com.liang.admin_4.domin.Product;
import com.liang.admin_4.service.ProductService;
import com.liang.admin_4.utils.CommonsUtils;
import com.liang.admin_4.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
        String id = CommonsUtils.getUUID();
        product.setId(id);
        productService.save(product);
        return "redirect:findAll.do";
    }

    //查询全部产品
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue =
            "1") int page, @RequestParam(name = "pageSize", required = true, defaultValue = "5")
                                        int pageSize) throws Exception  {

        ModelAndView  mv = new ModelAndView();
        PageBean productList = productService.findAll(1, 5);
        System.out.println(productList);
        List<Product> products = productService.findAll();

        mv.addObject("products",products);
        mv.setViewName("product-list");
        return  mv;
    }
}
