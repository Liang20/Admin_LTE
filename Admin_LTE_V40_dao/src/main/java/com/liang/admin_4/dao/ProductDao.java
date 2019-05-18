/**
 * @Author: Liang
 * @Date: 2019/5/18 21:36
 * @Version 1.0
 */
package com.liang.admin_4.dao;

import com.liang.admin_4.domin.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Liang
 * @date 2019/5/18 21:36
 */
public interface ProductDao {
    //根据id查询产品
    @Select("select * from product where id=#{id}")
    public Product findById(String id) throws Exception;

    //查询所有的产品信息
    @Select("select * from product")
    public List<Product> findAll() throws Exception;

    //添加产品
    @Insert("insert into product(id,productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{id},#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);

    //查询总记录数
    @Select("select count(*) from product")
    int getTotalCount () throws Exception;

    //分页查询
    @Select("select * from product limit #{Start},#{PageSize}")
    List<Product> getPageList(@Param("Start")int Start, @Param("PageSize") int PageSize) throws Exception;
}
