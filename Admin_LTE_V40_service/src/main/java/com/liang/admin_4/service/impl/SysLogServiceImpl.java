/**
 * @Author: Liang
 * @Date: 2019/5/19 23:50
 * @Version 1.0
 */
package com.liang.admin_4.service.impl;

import com.liang.admin_4.dao.SysLogDao;
import com.liang.admin_4.domin.SysLog;
import com.liang.admin_4.domin.UserInfo;
import com.liang.admin_4.service.SysLogService;
import com.liang.admin_4.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Liang
 * @date 2019/5/19 23:50
 */
@Service
@Transactional
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogDao sysLogDao;

    @Override
    public void save(SysLog sysLog) throws Exception {
        sysLogDao.save(sysLog);
    }

    @Override
    public List<SysLog> findAll() throws Exception {
        return sysLogDao.findAll();
    }

    @Override
    public PageBean findAll(int page, int pageSize) throws Exception {
        int totalcount = sysLogDao.getTotalCount();
        PageBean pageBean = new PageBean(page,totalcount,pageSize);
        List<SysLog>  userInfoList = sysLogDao.getPageList(pageBean.getStart(),pageSize);
        pageBean.setList(userInfoList);
        return pageBean;
    }
}
