package com.dao.impl;

import com.dao.ShopDao;
import com.entity.Shop;
import com.util.JDBCUtil;

import java.sql.ResultSet;

public class ShopDaoImp implements ShopDao {
    //保存商品信息
    @Override
    public int insertShop(Shop shop) {
        return JDBCUtil.adu(
                "insert into shop values(?,?,?,?,?,?,?,?)",
                shop.getId(),
                shop.getName(),
                shop.getDescription(),
                shop.getPrice(),
                shop.getStock(),
                shop.getLevel(),
                shop.getFilename(),
                shop.getIsDisCount());
    }

    //查询商品总数量
    @Override
    public ResultSet selAllShopNum() {
        return JDBCUtil.select("select count(*) from shop");
    }

    //查询每页需要查询的商品信息
    @Override
    public ResultSet selectPageShops(int index,int PageShopCount) {
        return JDBCUtil.select("select * from shop limit ?,?",index,PageShopCount);
    }

    //利用id删除商品信息
    @Override
    public int deleteShopById(int id) {
        return JDBCUtil.adu("delete from shop where id=?", id);
    }

    //利用id查询商品信息
    public ResultSet selectShopById(int id){
        return JDBCUtil.select("select * from shop where id=?", id);
    }

    //利用shop对象修改商品信息
    @Override
    public int updateShopByOb(Shop shop) {
        if (shop.getFilename()!=""){
            return JDBCUtil.adu("update shop " +
                    "set name=?,description=?,price=?,stock=?" +
                    ",level=?,filename=?,isDisCount=? where id=?",
                    shop.getName(),
                    shop.getDescription(),
                    shop.getPrice(),
                    shop.getStock(),
                    shop.getLevel(),shop.getFilename(),shop.getIsDisCount(),shop.getId());
        }else {
            return JDBCUtil.adu("update shop " +
                            "set name=?,description=?,price=?,stock=?" +
                            ",level=?,isDisCount=? where id=?",
                    shop.getName(),
                    shop.getDescription(),
                    shop.getPrice(),
                    shop.getStock(),
                    shop.getLevel(),shop.getIsDisCount(),shop.getId());
        }

    }
}
