/**
 * @Author: Liang
 * @Date: 2019/5/19 23:53
 * @Version 1.0
 */
package com.liang.admin_4.dao;

import com.liang.admin_4.domin.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Liang
 * @date 2019/5/19 23:53
 */
public interface SysLogDao {

    @Insert("insert into syslog(id,visitTime,username,ip,url,executionTime,method) values(#{id},#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    public void save(SysLog sysLog) throws Exception;

    @Select("select * from sysLog")
    List<SysLog> findAll() throws Exception;
}
