/**
 * @Author: Liang
 * @Date: 2019/5/18 21:28
 * @Version 1.0
 */
package com.liang.admin_4.dao;

import com.liang.admin_4.domin.Product;
import com.liang.admin_4.domin.Role;
import com.liang.admin_4.domin.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Liang
 * @date 2019/5/18 21:28
 */
public interface UserDao {
    //登录
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

    //查询总记录数
    @Select("select count(*) from users")
    int getTotalCount () throws Exception;

    //分页查询
    @Select("select * from users limit #{Start},#{PageSize}")
    List<UserInfo> getPageList(@Param("Start")int Start, @Param("PageSize") int PageSize) throws Exception;

    //添加用户
    @Insert("insert into users(id,email,username,password,phoneNum,status) values(#{id},#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo) throws Exception;

    //查询指定ID的用户
    @Select("select * from users where id=#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "com.liang.admin_4.dao.RoleDao.findRoleByUserId"))
    })
    UserInfo findById(String id)throws Exception;

    //根据ID查询未添加的用户
    @Select("select * from role where id not in (select roleId from users_role where userId=#{userId})")
    List<Role> findOtherRoles(String userId)throws Exception;

    //给用户添加角色
    @Insert("insert into users_role(userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") String userId,@Param("roleId") String roleId)throws  Exception;
}
