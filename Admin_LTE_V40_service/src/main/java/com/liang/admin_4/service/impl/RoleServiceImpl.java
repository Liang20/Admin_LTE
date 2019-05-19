/**
 * @Author: Liang
 * @Date: 2019/5/19 17:44
 * @Version 1.0
 */
package com.liang.admin_4.service.impl;

import com.liang.admin_4.dao.RoleDao;
import com.liang.admin_4.domin.Role;
import com.liang.admin_4.service.RoleService;
import com.liang.admin_4.utils.CommonsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Liang
 * @date 2019/5/19 17:44
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> findAll() throws Exception {
        List<Role> roleList = roleDao.findAll();
        return roleList;
    }

    @Override
    public void save(Role role) throws Exception{
        String id = CommonsUtils.getUUID();
        role.setId(id);
        roleDao.save(role);
    }
}
