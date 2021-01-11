package com.service.impl;

import com.dao.impl.LevelDaoImp;
import com.entity.Level;
import com.service.LevelService;
import com.util.JDBCUtil;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LevelServiceImp implements LevelService {

    //添加商品类型
    @Override
    public boolean insLevelInfo(Level level) {
        boolean b=false;
        try {
            if (new LevelDaoImp().insertLevelByOb(level)>0){
                b=true;
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close();
        }
        return b;
    }

    //查询所有分类
    @Override
    public List<Level> selLevelInfo() {
        List<Level> list=new ArrayList<>();
        Level level=null;
        ResultSet re=null;
        try {
            re=new LevelDaoImp().selectLevelAll();
            while (re.next()){
                level=new Level(re.getInt(1),re.getString(2));
                list.add(level);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close();
        }
        return list;
    }

    //删除byid
    @Override
    public boolean delLevelInfo(int id) {
        boolean b=false;
        try {
            if (new LevelDaoImp().deleteLevelById(id)>0){
                b=true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close();
        }
        return b;
    }

    //修改商品类型
    @Override
    public boolean updLevelInfo(Level level) {
        boolean b=false;
        try {
            if (new LevelDaoImp().updateLevelById(level)>0){
                b=true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close();
        }
        return b;
    }
}
