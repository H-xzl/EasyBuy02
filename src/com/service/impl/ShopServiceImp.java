package com.service.impl;

import com.dao.impl.ShopDaoImp;
import com.dao.impl.UserDaoImp;
import com.entity.Shop;
import com.service.ShopService;
import com.util.JDBCUtil;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ShopServiceImp implements ShopService {

    //接收信息存储
    @Override
    public boolean saveShop(Shop shop) {
        boolean T=false;
        try {
            if (new ShopDaoImp().insertShop(shop)>0){
                T=true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close();
        }
        //调用dao层存储信息
        return T;
    }

    //查询所有商品的个数
    @Override
    public int allShopsNum() {
        //调用dao层
        int SumShops = 0;
        ResultSet re = null;
        try {
            re=new ShopDaoImp().selAllShopNum();
            if (re.next()) {
                SumShops = re.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close();
        }
        return SumShops;
    }

    //查询当前页的所有的商品存储信息
    //参数当前页，每页要显示的数据条数
    @Override
    public List<Shop> selPageshopInfo(int page,int PageShopCount) {
        List<Shop> list=new ArrayList<>();
        Shop shop=null;

        int index=(page-1)*PageShopCount;
        ResultSet re;
        try {
            re=new ShopDaoImp().selectPageShops(index, PageShopCount);
            while (re.next()){
                shop=new Shop(re.getInt(1),
                        re.getString(2),
                        re.getString(3),
                        re.getInt(4),
                        re.getInt(5),
                        re.getString(6),
                        re.getString(7),
                        re.getInt(8));
                list.add(shop);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close();
        }
        return list;
    }

    //利用id删除商品信息
    @Override
    public boolean delShopInfo(int id) {
        boolean b=false;
        try {
            if(new ShopDaoImp().deleteShopById(id)>0){
                b=true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close();
        }
        return b;
    }

    //利用id查询商品信息
    @Override
    public Shop selShopInfo(int id) {
        Shop shop=null;
        //获取信息
        ResultSet re=new ShopDaoImp().selectShopById(id);
        try {
            if(re.next()){
                shop=new Shop(re.getInt(1),
                        re.getString(2),
                        re.getString(3),
                        re.getInt(4),
                        re.getInt(5),
                        re.getString(6),
                        re.getString(7),
                        re.getInt(8));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close();
        }
        return shop;
    }

    //修改商品信息
    @Override
    public boolean updShopIngfo(Shop shop){
        boolean b=false;
        try {
            if(new ShopDaoImp().updateShopByOb(shop)>0){
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
