package com.dao;

import com.entity.User;

import java.sql.ResultSet;

public interface UserDao {
    //查询登录用户
    public User loginDao(String username,String password);
    //判断用户名是否存在
    public ResultSet seAjRegister(String registerName);

    //保存用户
    public int addUser(User user);

    //求出用户总数
    public ResultSet countUser();

    //查询每页的集合
    public ResultSet selPageList(int page,int pagesum);

    //删除用户
    public int delUser(int id);

    //查询用户信息by id
    public ResultSet selInfoByID(int id);

    //修改用户信息by id
    public  int updateUserById(User user);

}
