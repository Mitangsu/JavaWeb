package book.service;

import book.pojo.OrderBean;
import book.pojo.User;

import java.util.List;

/**
 * @author shkstart
 * @create 2022-03-25 2:43
 */
public interface OrderService {
    void addOrderBean(OrderBean orderBean);
    List<OrderBean> getOrderList(User user);
}
