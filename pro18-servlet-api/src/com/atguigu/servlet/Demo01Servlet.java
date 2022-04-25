package com.atguigu.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author shkstart
 * @create 2022-03-16 9:33
 */
//@WebServlet(urlPatterns = {"/demo01"},
////        initParams = {
////            @WebInitParam(name="hello",value = "world"),
////            @WebInitParam(name="uname",value = "jim")
////        })
public class Demo01Servlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        //获取config对象
        ServletConfig config = getServletConfig();
        //获取初始化参数值
        String initValue = config.getInitParameter("hello");
//        System.out.println("initValue =" + initValue);
        //获取Servlet上下文
        ServletContext servletContext = getServletContext();
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");
        System.out.println(contextConfigLocation);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getServletContext();
        req.getSession().getServletContext();
    }

}

//Servlet生命周期:实例化、初始化、服务、销毁
