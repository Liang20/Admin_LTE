/**
 * @Author: Liang
 * @Date: 2019/5/18 21:28
 * @Version 1.0
 */
package com.liang.admin_4.dao;

import com.liang.admin_4.domin.Permission;
import com.liang.admin_4.domin.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Liang
 * @date 2019/5/18 21:28
 */
public interface RoleDao {
    //根据用户id查询出所有对应的角色
    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(id = true, property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id" ,javaType = java.util.List.class,
                    many = @Many(select = "com.liang.admin_4.dao.PermissionDao.findPermissionByRoleId")
            )

    })
    public List<Role> findRoleByUserId(String userId) throws Exception;

    //查询所有角色
    @Select("select * from role")
    public List<Role> findAll()throws Exception;

    @Insert("insert into role(id,roleName,roleDesc) values(#{id},#{roleName},#{roleDesc})")
    void save(Role role)throws Exception;

    @Select("select * from role where id=#{roleId}")
    Role findById(String roleId);

    @Select("select * from permission permission where id not in (select  permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findOtherPermission(String roleId);

    @Insert("insert into role_permission(roleId,permissionId) values(#{roleId},#{permissionId})")
    void addPermissionToRole(@Param("roleId") String roleId, @Param("permissionId") String permissionId);
}
