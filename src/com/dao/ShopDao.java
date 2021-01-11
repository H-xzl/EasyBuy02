package com.dao;

import com.entity.Shop;

import java.sql.ResultSet;

public interface ShopDao {
    //利用shop对象存储信息
    public int insertShop(Shop shop);

    //查询商品总数量
    public ResultSet selAllShopNum();

    //查询特定页的商品信息
    //index:sevice层处理后的位置，PageShopCount：查询数量
    public ResultSet selectPageShops(int index, int PageShopCount);

    //利用id删除商品信息
    public int deleteShopById(int id);

    //利用id查询商品信息
    public ResultSet selectShopById(int id);

    //利用shop对象修改商品信息
    public int updateShopByOb(Shop shop);
}
