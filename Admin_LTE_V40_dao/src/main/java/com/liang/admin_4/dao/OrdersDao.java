/**
 * @Author: Liang
 * @Date: 2019/5/18 22:32
 * @Version 1.0
 */
package com.liang.admin_4.dao;

import com.liang.admin_4.domin.Orders;
import com.liang.admin_4.domin.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Liang
 * @date 2019/5/18 22:32
 */
public interface OrdersDao {

    //分页查询
    @Select("select * from orders limit #{Start},#{PageSize}")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product",one = @One(select =
                    "com.liang.admin_4.dao.ProductDao.findById"))
    })
    List<Orders> getPageList(@Param("Start")int Start, @Param("PageSize") int PageSize) throws Exception;

    //查询总记录数
    @Select("select count(*) from orders")
    int getTotalCount () throws Exception;


    @Select("select * from orders where id=#{id}")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product",one = @One(select =
                    "com.liang.admin_4.dao.ProductDao.findById")),
            @Result(column = "id",property = "travellers",many = @Many(select =
                    "com.liang.admin_4.dao.TravellerDao.findByOrdersId")),
            @Result(column = "memberId",property = "member",one = @One(select =
                    "com.liang.admin_4.dao.MemberDao.findById")),
    })
    Orders findById(String id) throws Exception;
}
