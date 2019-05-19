/**
 * @Author: Liang
 * @Date: 2019/5/19 18:46
 * @Version 1.0
 */
package com.liang.admin_4.service;

import com.liang.admin_4.domin.Permission;

import java.util.List;

/**
 * @author Liang
 * @date 2019/5/19 18:46
 */
public interface PermissionService {

    public List<Permission> findAll() throws  Exception;

    void save(Permission permission) throws Exception;
}
