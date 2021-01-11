package com.util;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.entity.Shop;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class OnloadUtil {

    public static Map<String, String> getMap(HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();
        // 创建磁盘文件项工厂:
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        // 创建核心解析类:
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        try {
            List<FileItem> list = servletFileUpload.parseRequest(request);
            for (FileItem item : list) {
                if (item.isFormField()) {//普通项
                    map.put(item.getFieldName(), item.getString("utf-8"));
                } else {//上传项
                    //1.获取上传的地址和文件名
                    String path = "D:\\shops";
                    String filename = item.getName();
                    if (filename != "") {
                        //System.out.println("类型:..."+filename+"修改完后的文件名");
                        //把文件名存入map集合
                        //System.out.println("我正在做流....");
                        //2.创建写入流
                        FileOutputStream fo =
                                new FileOutputStream(path + "\\" + filename);
                        //3.创建读取流
                        InputStream is = item.getInputStream();
                        //4.边读编写
                        byte[] arr = new byte[1024];
                        int len = 0;
                        while ((len = is.read(arr)) != -1) {
                            fo.write(arr, 0, len);
                        }
                        fo.close();
                        is.close();
                    }
                    map.put(item.getFieldName(), filename);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }


    //把map集合中的数据转化成shop对象
    public static Shop getShop(Map<String, String> map) {
        return new Shop(
                null,
                map.get("shopname"),
                map.get("description"),
                Integer.parseInt(map.get("price")),
                Integer.parseInt(map.get("stock")),
                map.get("level"),
                map.get("filename"),
                Integer.parseInt(map.get("isDisCount")));
    }
    public static Shop updShop(Map<String, String> map) {
        return new Shop(
                Integer.parseInt(map.get("id")),
                map.get("shopname"),
                map.get("description"),
                Integer.parseInt(map.get("price")),
                Integer.parseInt(map.get("stock")),
                map.get("level"),
                map.get("filename"),
                Integer.parseInt(map.get("isDisCount")));
    }
}

