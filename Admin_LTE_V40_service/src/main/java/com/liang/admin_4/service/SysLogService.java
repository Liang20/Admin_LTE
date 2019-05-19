/**
 * @Author: Liang
 * @Date: 2019/5/19 23:49
 * @Version 1.0
 */
package com.liang.admin_4.service;

import com.liang.admin_4.domin.SysLog;

import java.util.List;

/**
 * @author Liang
 * @date 2019/5/19 23:49
 */
public interface SysLogService {
    public  void save(SysLog sysLog)throws  Exception;

    List<SysLog> findAll() throws  Exception;
}
