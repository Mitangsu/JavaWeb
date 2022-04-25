package com.atguigu.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 演示Session
 * @author shkstart
 * @create 2022-03-13 2:22
 */
public class Demo03Servlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取session,如果获取不到,则创建一个新的
        HttpSession session = request.getSession();
        //获取sessionID
        System.out.println("session ID" + session.getId());
        // session的非激活间隔时常 默认1800秒 (相当于银行软件多长时间不操作,再进窗口操作显示重新进入,当前会话结束)
        session.getMaxInactiveInterval();

    }
}
