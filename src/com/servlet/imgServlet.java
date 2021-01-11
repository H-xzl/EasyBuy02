package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@WebServlet("/imgServlet")
public class imgServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public imgServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.接收文件名:
        String filename = request.getParameter("filename");
        // 2.获得download的磁盘绝对路径.
        String path = "D:\\shops";
        // 3.设置两个头和一个流:
        // 动态获得文件的MIME的类型:
        String mimeType = this.getServletContext().getMimeType(filename);
        response.setContentType(mimeType);
        // 设置Content-Dispostion:
        response.setHeader("Content-Disposition", "filename="+filename);
        // 设置文件的输入流InputStream:
        InputStream is = new FileInputStream(path+"\\"+filename);
        // 获得一个向浏览器输出的一个输出流:

        //需要通过输出流进行下载,下载的写入是通过浏览器进行下载的,所以直接从响应头中获取输出流
        OutputStream os = response.getOutputStream();
        byte[] b = new byte[1024];
        int len = 0;
        while((len = is.read(b))!=-1){
            os.write(b, 0, len);
        }
        is.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
