/**
 * @Author: Liang
 * @Date: 2019/5/18 20:55
 * @Version 1.0
 */
package com.liang.admin_4.service;

import com.liang.admin_4.domin.UserInfo;
import com.liang.admin_4.utils.PageBean;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author Liang
 * @date 2019/5/18 20:55
 */
public interface UserService extends UserDetailsService {
    //分页查询
    public PageBean findAll(int page, int pageSize) throws Exception;

    //添加用户
    void save(UserInfo userInfo) throws Exception;
}
