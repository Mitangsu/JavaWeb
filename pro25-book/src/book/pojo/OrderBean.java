package book.pojo;

import java.util.Date;
import java.util.List;

/**
 * @author shkstart
 * @create 2022-03-24 8:41
 */
public class OrderBean {
    private Integer id;
    private String orderNo;//订单编号
    private Date orderDate;//订单日期
    private User orderUser;//谁订购
    private Double orderMoney;//订单金额
    private Integer orderStatus;//订单状态

    private List<OrderItem> orderItemList; //1:N
    private Integer totalBookCount;

    public OrderBean(Integer id) {

        this.id = id;
    }

    public OrderBean() {
    }

    public Integer getTotalBookCount() {

        return totalBookCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public User getOrderUser() {
        return orderUser;
    }

    public void setOrderUser(User orderUser) {
        this.orderUser = orderUser;
    }

    public Double getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Double orderMoney) {
        this.orderMoney = orderMoney;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setTotalBookCount(Integer totalBookCount) {
        this.totalBookCount = totalBookCount;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
}
