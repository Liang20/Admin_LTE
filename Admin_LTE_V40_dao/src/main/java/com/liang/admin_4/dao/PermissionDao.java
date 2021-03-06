/**
 * @Author: Liang
 * @Date: 2019/5/19 16:59
 * @Version 1.0
 */
package com.liang.admin_4.dao;

import com.liang.admin_4.domin.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Liang
 * @date 2019/5/19 16:59
 */
public interface PermissionDao {

    @Select("select *  from  permission where id in (select permissionId from role_permission where roleId=#{id})")
    public List<Permission> findPermissionByRoleId(String id) throws  Exception;

    //查询所有
    @Select("select * from permission")
    List<Permission> findAll() throws  Exception;

    @Insert("insert into permission(id,permissionName,url) values(#{id},#{permissionName},#{url})")
    void save(Permission permission) throws Exception;
}
