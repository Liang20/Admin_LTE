/**
 * @Author: Liang
 * @Date: 2019/5/20 0:46
 * @Version 1.0
 */
package com.liang.admin_4.web;

import com.liang.admin_4.domin.SysLog;
import com.liang.admin_4.service.SysLogService;
import com.liang.admin_4.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Liang
 * @date 2019/5/20 0:46
 */
@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue =
            "1") Integer page, @RequestParam(name = "pageSize", required = true, defaultValue = "5")
                                            Integer pageSize)throws Exception{
        ModelAndView mv = new ModelAndView();
        PageBean pageBeanList = sysLogService.findAll(page, pageSize);
        mv.addObject("pageBeanList",pageBeanList);
        mv.setViewName("syslog-list");
        return mv;
    }
}
