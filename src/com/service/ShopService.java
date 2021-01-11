package com.service;

import com.entity.Shop;

import java.util.List;

public interface ShopService {
    //接收信息存储
    public boolean saveShop(Shop shop);

    //查询所有商品的个数
    public int allShopsNum();

    //查询当前页的所有的商品存储信息
    //参数当前页，每页要显示的数据条数
    public List<Shop> selPageshopInfo(int page,int PageShopCount);

    //利用id删除商品信息
    public boolean delShopInfo(int id);

    //利用id查询商品信息
    public Shop selShopInfo(int id);

    //修改商品信息
    public boolean updShopIngfo(Shop shop);
}
