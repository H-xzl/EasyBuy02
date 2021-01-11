package com.service.impl;

import com.dao.UserDao;
import com.dao.impl.UserDaoImp;
import com.entity.User;
import com.service.UserService;
import com.util.JDBCUtil;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImp implements UserService {
    //处理登录业务
    @Override
    public User loginService(String username, String passward) {
        return new UserDaoImp().loginDao(username, passward);
    }

    //判断注册时用户名是否存在
    @Override
    public boolean selectRegistName(String registerName) {
        //接收dao层的re
        ResultSet re = new UserDaoImp().seAjRegister(registerName);
        try {
            if (re.next()) {
                //用户名已存在
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close();
        }
        //用户名不存在
        return false;
    }

    //保存用户
    @Override
    public boolean addUser(User user) {
        boolean T = false;
        try {
            if (new UserDaoImp().addUser(user) > 0) {
                T = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close();
        }
        return T;
    }

    //查询所有的用户数量
    @Override
    public int selectUserCount() {
        int SumUser = 0;
        ResultSet re = new UserDaoImp().countUser();

        try {
            if (re.next()) {
                SumUser = re.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close();
        }
        return SumUser;
    }

    //查询每页的用户集合
    @Override
    public List<User> selPageList(int page, int pagesum) {
        int index = (page - 1) * pagesum;//要查询的导航地址
        List<User> list = new ArrayList<>();
        User user = null;
        ResultSet re = new UserDaoImp().selPageList(index, pagesum);
        try {
            while (re.next()) {
                //将查询内容添加到集合中返回到servlet
                user = new User(
                        re.getInt(1),
                        re.getString(2),
                        re.getString(3),
                        re.getString(4),
                        re.getString(5),
                        re.getInt(6));
                list.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close();
        }
        return list;
    }

    //删除用户
    @Override
    public boolean delUser(int id) {
        boolean T = false;
        try {
            if (new UserDaoImp().delUser(id) > 0) {
                T = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close();
        }
        return T;
    }

    // 按id查询用户信息
    @Override
    public User selectById(int id) {
        ResultSet re = new UserDaoImp().selInfoByID(id);
        User user = null;
        try {
            if (re.next()) {
                user = new User(
                        re.getInt(1),
                        re.getString(2),
                        re.getString(3),
                        re.getString(4),
                        re.getString(5),
                        re.getInt(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close();
        }
        return user;
    }

    //按id修改用户信息
    public boolean updUserById(User user) {
        boolean b = false;
        //调用dao层修改信息
        try {
            if ((new UserDaoImp().updateUserById(user)) > 0) {
                b = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close();
        }
        // 返回修改结果
        return b;
    }

}
