package book.impl;

import book.DAO.OrderItemDAO;
import book.pojo.OrderItem;
import com.atguigu.myssm.basedao.BaseDAO;


/**
 * @author shkstart
 * @create 2022-03-25 2:40
 */
public class OrderItemDAOImpl extends BaseDAO<OrderItem> implements OrderItemDAO {
    @Override
    public void addOrderItem(OrderItem orderItem) {
        super.executeUpdate("insert into t_order_item values(0,?,?,?)",orderItem.getBook().getId(),orderItem.getBuyCount(),orderItem.getOrderBean().getId()) ;
    }
}
