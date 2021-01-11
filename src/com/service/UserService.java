package com.service;

import com.entity.User;

import java.util.List;

public interface UserService {
    //处理登录业务
    public User loginService(String username,String passward);
    //判断注册时用户名是否存在
    public boolean selectRegistName(String registerName);
    //保存用户
    public  boolean addUser(User user);

    //查询所有的用户数量
    public int selectUserCount();

    //查询每页的用户集合
    public List<User> selPageList(int page,int pagenum);

    //删除用户
    public boolean delUser(int id);

    // 按id查询用户信息
    public User selectById(int id);

    //按id修改用户信息
    public boolean updUserById(User user);

}
