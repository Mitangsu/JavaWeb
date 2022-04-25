package myssm.filters;




import myssm.trans.TransactionManager;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author shkstart
 * @create 2022-03-17 17:11
 */
@WebFilter("*.do")
public class OpenSessionInViewFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            TransactionManager.beginTrans();
            System.out.println("开启事务....");
            filterChain.doFilter(servletRequest,servletResponse);
            TransactionManager.commit();
            System.out.println("提交事务....");
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                TransactionManager.roolback();
                System.out.println("回滚事务....");
            } catch (SQLException e1) {

                e1.printStackTrace();
            }
        }
    }

    @Override
    public void destroy() {

    }
}
