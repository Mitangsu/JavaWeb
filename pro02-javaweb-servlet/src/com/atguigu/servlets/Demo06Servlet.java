package com.atguigu.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 演示服务器端内部转发以及客户端重定向
 * @author shkstart
 * @create 2022-03-13 13:11
 */
public class Demo06Servlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo06.....");
        //服务器端内部转发1
//      request.getRequestDispatcher("demo07").forward(request,resp);
//        客户端重定向
        resp.sendRedirect("demo07");

    }
}
