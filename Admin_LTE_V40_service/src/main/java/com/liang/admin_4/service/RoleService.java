/**
 * @Author: Liang
 * @Date: 2019/5/19 17:44
 * @Version 1.0
 */
package com.liang.admin_4.service;

import com.liang.admin_4.domin.Role;

import java.util.List;

/**
 * @author Liang
 * @date 2019/5/19 17:44
 */
public interface RoleService {

    public List<Role> findAll() throws  Exception;

    void save(Role role)throws Exception;
}
