package com.entity;

import java.io.Serializable;

//实现上传下载
public class Shop implements Serializable {

    private Integer id;//id
    private String name;//名称
    private String description;//描述
    private Integer price;//价格
    private Integer stock;//库存
    private String level;//所属类型
    private String filename;//图片文件地址
    private Integer isDisCount;//是否热卖

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", level='" + level + '\'' +
                ", filename='" + filename + '\'' +
                ", isDisCount=" + isDisCount +
                '}';
    }

    public Shop(Integer id, String name, String description, Integer price, Integer stock, String level, String filename, Integer isDisCount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.level = level;
        this.filename = filename;
        this.isDisCount = isDisCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Integer getIsDisCount() {
        return isDisCount;
    }

    public void setIsDisCount(Integer isDisCount) {
        this.isDisCount = isDisCount;
    }
}
