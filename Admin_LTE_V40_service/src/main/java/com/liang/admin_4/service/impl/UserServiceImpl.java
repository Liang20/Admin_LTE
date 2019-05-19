/**
 * @Author: Liang
 * @Date: 2019/5/18 20:56
 * @Version 1.0
 */
package com.liang.admin_4.service.impl;

import com.liang.admin_4.dao.UserDao;
import com.liang.admin_4.domin.Product;
import com.liang.admin_4.domin.Role;
import com.liang.admin_4.domin.UserInfo;
import com.liang.admin_4.service.UserService;
import com.liang.admin_4.utils.CommonsUtils;
import com.liang.admin_4.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liang
 * @date 2019/5/18 20:56
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //登录
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            userInfo = userDao.findByUsername(username);
            System.out.println(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //处理自己的用户对象封装成UserDetails
        //  User user=new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),getAuthority(userInfo.getRoles()));
        User user = new User(userInfo.getUsername(), userInfo.getPassword(), userInfo.getStatus() == 0 ? false : true, true, true, true, getAuthority(userInfo.getRoles()));
        return user;
    }

    //作用就是返回一个List集合，集合中装入的是角色描述
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {

        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return list;
    }


    //分页查询
    @Override
    public PageBean findAll(int page, int pageSize) throws Exception {
        int totalcount = userDao.getTotalCount();
        PageBean pageBean = new PageBean(page,totalcount,pageSize);
        List<UserInfo>  userInfoList = userDao.getPageList(pageBean.getStart(),pageSize);
        pageBean.setList(userInfoList);
        return pageBean;
    }

    //添加用户
    @Override
    public void save(UserInfo userInfo) throws Exception{
        String id = CommonsUtils.getUUID();
        userInfo.setId(id);
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        userDao.save(userInfo);
    }

    @Override
    public UserInfo findById(String id) throws Exception {

        return userDao.findById(id);
    }
}
