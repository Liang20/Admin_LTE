/**
 * @Author: Liang
 * @Date: 2019/5/18 21:28
 * @Version 1.0
 */
package com.liang.admin_4.dao;

import com.liang.admin_4.domin.UserInfo;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @author Liang
 * @date 2019/5/18 21:28
 */
public interface UserDao {
    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "com.liang.admin_4.dao.RoleDao.findRoleByUserId"))
    })
    public UserInfo findByUsername(String username) throws Exception;
}
