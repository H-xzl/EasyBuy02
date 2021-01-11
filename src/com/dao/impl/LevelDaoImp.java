package com.dao.impl;

import com.dao.LevelDao;
import com.entity.Level;
import com.util.JDBCUtil;

import java.sql.ResultSet;

public class LevelDaoImp implements LevelDao {
    //添加商品类型
    @Override
    public int insertLevelByOb(Level level) {
        return JDBCUtil.adu("insert into shoplevel values(?,?)",
                level.getId(),level.getShoplevelname());
    }

    //查询分类
    @Override
    public ResultSet selectLevelAll() {
        return JDBCUtil.select("select * from shoplevel");
    }


    //删除商品类型
    @Override
    public int deleteLevelById(int id) {
        return JDBCUtil.adu("delete from shoplevel where id=?",id);
    }

    //修改商品类型
    @Override
    public int updateLevelById(Level level) {
        return JDBCUtil.adu("update shoplevel set shoplevelname=? where id=?",
                level.getShoplevelname(),level.getId());
    }


}
