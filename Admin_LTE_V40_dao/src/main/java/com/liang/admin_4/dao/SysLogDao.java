/**
 * @Author: Liang
 * @Date: 2019/5/19 23:53
 * @Version 1.0
 */
package com.liang.admin_4.dao;

import com.liang.admin_4.domin.SysLog;
import com.liang.admin_4.domin.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
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

    //查询总记录数
    @Select("select count(*) from sysLog")
    int getTotalCount () throws Exception;

    //分页查询
    @Select("select * from sysLog limit #{Start},#{PageSize}")
    List<SysLog> getPageList(@Param("Start")int Start, @Param("PageSize") int PageSize) throws Exception;

}
