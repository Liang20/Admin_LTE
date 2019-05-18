/**
 * @Author: Liang
 * @Date: 2019/5/18 23:15
 * @Version 1.0
 */
package com.liang.admin_4.utils;

import java.util.List;

/**
 * @author Liang
 * @date 2019/5/18 23:15
 */
public class PageBean {
    //当前页数
    private Integer currentPage;
    //总记录数
    private Integer totalCount;
    //每页显示条数
    private Integer  pageSize;
    //总页数
    private Integer  totalPage;
    //分页列表数据
    private List list;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public PageBean(Integer currentPage, Integer totalCount, Integer pageSize) {
        this.currentPage = currentPage;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        //默认指定第一页
        if(this.currentPage == null){
            this.currentPage = 1;
        }

        //默认指定每一页三条数据
        if(this.pageSize == null){
            this.pageSize = 3;
        }

        //计算总页数
        this.totalPage = (this.totalCount+this.pageSize-1)/this.pageSize;

        //判断当前页数是否超出范围
        if(this.currentPage < 1){
            this.currentPage = 1;
        }
        if(this.currentPage > this.totalPage){
            this.currentPage = 1;
        }

    }

    //计算起始索引
    public int getStart(){
        return (this.currentPage - 1)*this.pageSize;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "currentPage=" + currentPage +
                ", totalCount=" + totalCount +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                ", list=" + list +
                '}';
    }
}
