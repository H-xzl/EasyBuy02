package com.dao.impl;

import com.dao.UserDao;
import com.entity.User;
import com.util.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImp implements UserDao {
    //查询登录用户
    @Override
    public User loginDao(String username, String password) {
        //1.创建用户对象
        User user=null;
        //2.查询数据库
        try {
            ResultSet re = JDBCUtil.select(
                    "select * from user where loginname=? and password=?",
                    username,password);
            if(re.next()){
                user=new User(
                        re.getInt(1),
                        re.getString(2),
                        re.getString(3),
                        re.getString(4),
                        re.getString(5),
                        re.getInt(6));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close();
        }

        return user;
    }

    //判断用户名是否存在
    @Override
    public ResultSet seAjRegister(String registerName) {
        return JDBCUtil.select("select * from user where loginname=?",registerName) ;
    }

    //保存用户
    @Override
    public int addUser(User user) {
        return JDBCUtil.adu(
                "insert into user values(?,?,?,?,?,?)",
                user.getId(),
                user.getLoginname(),
                user.getUsername(),
                user.getPassword(),
                user.getSex(),
                user.getType());
    }

    //求出用户总数
    @Override
    public ResultSet countUser() {
        return JDBCUtil.select("select count(*) from user");
    }

    //查询每页需要显示的用户信息
    @Override
    public ResultSet selPageList(int index, int pagesum) {
        return JDBCUtil.select("select * from user limit ?,?",index,pagesum);
    }

    //删除用户
    @Override
    public int delUser(int id) {
        return JDBCUtil.adu("delete from user where id=?", id);
    }

    //查询用户信息by id
    @Override
    public ResultSet selInfoByID(int id) {
        return JDBCUtil.select("select * from user where id=?",id);
    }

    //修改用户信息by id
    public  int updateUserById(User user){
        return JDBCUtil.adu("update user set loginname=?,username=?,password=? where id=?",user.getLoginname(),user.getUsername(),user.getPassword(),user.getId() );
    }

}
