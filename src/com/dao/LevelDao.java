package com.dao;

import com.entity.Level;

import java.sql.ResultSet;

public interface LevelDao {
    //添加商品类型
public int insertLevelByOb(Level level);
//查询分类
    public ResultSet selectLevelAll();

    //删除商品类型
    public int deleteLevelById(int id);

    //修改商品类型
    public int updateLevelById(Level level);
}
