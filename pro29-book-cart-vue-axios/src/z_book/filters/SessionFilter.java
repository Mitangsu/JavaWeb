package z_book.filters;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;


/**
 * @author shkstart
 * @create 2022-03-26 6:17
 */
//@WebFilter(urlPatterns = {"*.do", "*.html"},
//        initParams = {
//                @WebInitParam(name = "bai",
//                        value = "/pro25/page.do?operate=page&page=/user/login,/pro25/user.do?null")
//        })
public class SessionFilter implements Filter {
    List<String> baiLiST = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String bai = filterConfig.getInitParameter("bai");
        String[] baiArr = bai.split(",");
        baiLiST = Arrays.asList(baiArr);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String url = request.getRequestURI();
        String queryString = request.getQueryString();
        String str = url + "?" + queryString;
        if (baiLiST.contains(str)) {
            filterChain.doFilter(request, response);
        } else {
            HttpSession session = request.getSession();
            Object currUserObj = session.getAttribute("currUser");

            if (currUserObj == null) {
                response.sendRedirect("page.do?operate=page&page=user/login");
            } else {
                filterChain.doFilter(request, response);
            }
        }


    }

    @Override
    public void destroy() {

    }
}
