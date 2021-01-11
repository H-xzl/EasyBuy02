package com.service;

import com.entity.Level;

import java.util.List;

public interface LevelService {
    //添加商品类型
 public boolean insLevelInfo(Level level);

 //查询所有分类
    public List<Level> selLevelInfo();

    //删除商品类型
    public boolean delLevelInfo(int id);

    //修改商品类型
    public boolean updLevelInfo(Level level);
}
