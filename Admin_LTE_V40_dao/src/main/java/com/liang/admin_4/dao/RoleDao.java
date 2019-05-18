/**
 * @Author: Liang
 * @Date: 2019/5/18 21:28
 * @Version 1.0
 */
package com.liang.admin_4.dao;

import com.liang.admin_4.domin.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Liang
 * @date 2019/5/18 21:28
 */
public interface RoleDao {
    //根据用户id查询出所有对应的角色
    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    public List<Role> findRoleByUserId(String userId) throws Exception;
}
