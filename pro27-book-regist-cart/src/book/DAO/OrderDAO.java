package book.DAO;

import book.pojo.OrderBean;
import book.pojo.User;

import java.util.List;

/**
 * @author shkstart
 * @create 2022-03-25 2:33
 */
public interface OrderDAO {
    //添加订单
    void addOrderBean(OrderBean orderBean);
    //获取指定用户的订单列表
    List<OrderBean> getOrderList(User user);

    Integer getOrderTotalBookCount(OrderBean orderBean);
}
