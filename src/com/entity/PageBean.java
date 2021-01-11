package com.entity;

import java.util.List;

public class PageBean {
    private Integer page;//当前页
    private Integer pageSum;//每页显示的条数
    private Integer countSum;//总条数
    private Integer countPage;//总页数
    private List<User> list;//每页的数据

    public PageBean() {
    }

    public PageBean(Integer page, Integer pageSum, Integer countSum, Integer countPage, List<User> list) {
        this.page = page;
        this.pageSum = pageSum;
        this.countSum = countSum;
        this.countPage = countPage;
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "page=" + page +
                ", pageSum=" + pageSum +
                ", countSum=" + countSum +
                ", countPage=" + countPage +
                ", list=" + list +
                '}';
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSum() {
        return pageSum;
    }

    public void setPageSum(Integer pageSum) {
        this.pageSum = pageSum;
    }

    public Integer getCountSum() {
        return countSum;
    }

    public void setCountSum(Integer countSum) {
        this.countSum = countSum;
    }

    public Integer getCountPage() {
        return countPage;
    }

    public void setCountPage(Integer countPage) {
        this.countPage = countPage;
    }

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }
}
