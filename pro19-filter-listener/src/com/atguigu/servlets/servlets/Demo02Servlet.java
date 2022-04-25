package com.atguigu.servlets.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author shkstart
 * @create 2022-03-17 13:51
 */
@WebServlet("/demo02.do")
public class Demo02Servlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo02,service....");
        request.getRequestDispatcher("succ.html").forward(request,response);//跳转到某个网站
    }
}
