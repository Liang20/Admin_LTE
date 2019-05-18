/**
 * @Author: Liang
 * @Date: 2019/5/18 22:31
 * @Version 1.0
 */
package com.liang.admin_4.dao;

import com.liang.admin_4.domin.Member;
import org.apache.ibatis.annotations.Select;

/**
 * @author Liang
 * @date 2019/5/18 22:31
 */
public interface MemberDao {

    @Select("select * from member where id=#{id}")
    Member findById(String id) throws Exception;

}
