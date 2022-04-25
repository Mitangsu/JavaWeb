package com.atguigu.qqzone.myssm.filters;



import com.atguigu.qqzone.myssm.util.StringUtil;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author shkstart
 * @create 2022-03-17 15:19
 */
@WebFilter(urlPatterns = {"*.do"},initParams = {@WebInitParam(name ="encoding",value = "UTF-8")})
public class CharacterEncodingFilter implements Filter {

    private String encoding = "Utf-8";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String encodingStr = filterConfig.getInitParameter("encoding");
        if (StringUtil.isNotEmpty(encodingStr)){
            encoding=encodingStr;
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //设置编码
        ((HttpServletRequest)servletRequest).setCharacterEncoding(encoding);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
