/**
 * @Author: Liang
 * @Date: 2019/5/19 15:51
 * @Version 1.0
 */
package com.liang.admin_4.web;

import com.liang.admin_4.domin.Role;
import com.liang.admin_4.domin.UserInfo;
import com.liang.admin_4.service.UserService;
import com.liang.admin_4.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Liang
 * @date 2019/5/19 15:51
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //分页查询
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue =
            "1") int page, @RequestParam(name = "pageSize", required = true, defaultValue = "5")
                                        int pageSize) throws Exception{
        ModelAndView  mv = new ModelAndView();
        PageBean pageBeanList = userService.findAll(page, pageSize);
        mv.addObject("pageBeanList",pageBeanList);
        mv.setViewName("user-list");
        return mv;
    }

    //添加用户
    @RequestMapping("/save.do")
    public String save(UserInfo userInfo) throws  Exception{
        userService.save(userInfo);
        return  "redirect:findAll.do";
    }

    //查询指定ID的用户
    @RequestMapping("/findById.do")
    public  ModelAndView findById(String id) throws  Exception{
        ModelAndView  mv = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        mv.addObject("user",userInfo);
        mv.setViewName("user-show");
        return mv;
    }

    //查询用户未拥有的角色
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name="id",required = true) String userid) throws Exception{
        //根据ID查询用户
        UserInfo userInfo = userService.findById(userid);
        //根据ID查询未添加的用户
        List<Role> otherRoles = userService.findOtherRoles(userid);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user",userInfo);
        mv.addObject("roleList",otherRoles);
        mv.setViewName("user-role-add");
        return mv;
    }

    //给用户添加角色
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId",required = true) String userId,@RequestParam(name = "ids",required = true) String[] roleIds)throws Exception{
        userService.addRoleToUser(userId,roleIds);
        return "redirect:findAll.do";
    }

}
