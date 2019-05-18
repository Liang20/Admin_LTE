/**
 * @Author: Liang
 * @Date: 2019/5/18 22:33
 * @Version 1.0
 */
package com.liang.admin_4.dao;

import com.liang.admin_4.domin.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Liang
 * @date 2019/5/18 22:33
 */
public interface TravellerDao {

    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId=#{ordersId})")
    List<Traveller> findByOrdersId(String ordersId) throws Exception;
}
