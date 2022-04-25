package com.atguigu.servlets.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author shkstart
 * @create 2022-03-17 14:14
 */
//@WebFilter("/demo01.do")
//@WebFilter("*.do")
public class Demo01Filter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("helloA");
        //放行
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("helloA3");
    }

    @Override
    public void destroy() {

    }
}
