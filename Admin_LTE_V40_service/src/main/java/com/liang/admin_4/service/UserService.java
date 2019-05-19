/**
 * @Author: Liang
 * @Date: 2019/5/18 20:55
 * @Version 1.0
 */
package com.liang.admin_4.service;

import com.liang.admin_4.domin.Role;
import com.liang.admin_4.domin.UserInfo;
import com.liang.admin_4.utils.PageBean;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author Liang
 * @date 2019/5/18 20:55
 */
public interface UserService extends UserDetailsService {
    //分页查询
    public PageBean findAll(int page, int pageSize) throws Exception;

    //添加用户
    void save(UserInfo userInfo) throws Exception;

    //根据ID查询用户
    UserInfo findById(String id) throws  Exception;

    //根据ID查询未添加的用户
    List<Role> findOtherRoles(String userid)throws Exception;

    //给用户添加角色
    void addRoleToUser(String userId, String[] roleIds)throws  Exception;
}
