/**
 * @Author: Liang
 * @Date: 2019/5/19 17:41
 * @Version 1.0
 */
package com.liang.admin_4.web;

import com.liang.admin_4.domin.Role;
import com.liang.admin_4.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Liang
 * @date 2019/5/19 17:41
 */
@RequestMapping("/role")
@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Role> roleList = roleService.findAll();
        mv.addObject("roleList",roleList);
        mv.setViewName("role-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public  String save(Role role)throws  Exception{
        roleService.save(role);
        return "redirect:findAll.do";
    }
}
