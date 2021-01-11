package com.entity;
import java.io.Serializable;

public class Level implements Serializable {
    private Integer id;
    private String  shoplevelname;

    public Level() {
    }
    @Override
    public String toString() {
        return "Level{" +
                "id=" + id +
                ", shoplevelname='" + shoplevelname + '\'' +
                '}';
    }

    public Level(Integer id, String shoplevelname) {
        this.id = id;
        this.shoplevelname = shoplevelname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShoplevelname() {
        return shoplevelname;
    }

    public void setShoplevelname(String shoplevelname) {
        this.shoplevelname = shoplevelname;
    }
}
