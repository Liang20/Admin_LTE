/**
 * @Author: Liang
 * @Date: 2019/5/19 18:46
 * @Version 1.0
 */
package com.liang.admin_4.service.impl;

import com.liang.admin_4.dao.PermissionDao;
import com.liang.admin_4.domin.Permission;
import com.liang.admin_4.service.PermissionService;
import com.liang.admin_4.utils.CommonsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Liang
 * @date 2019/5/19 18:46
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<Permission> findAll() throws Exception {
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) throws Exception {
        String id = CommonsUtils.getUUID();
        permission.setId(id);
        permissionDao.save(permission);
    }
}
