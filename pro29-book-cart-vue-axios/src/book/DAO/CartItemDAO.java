package book.DAO;

import book.pojo.CartItem;
import book.pojo.User;

import java.util.List;

/**
 * @author shkstart
 * @create 2022-03-24 21:55
 */
public interface CartItemDAO {
    //新增购物车项
    void addCartItem(CartItem cartItem);
    //修改特定的购物车项
    void updateCartItem(CartItem cartItem);
    //获取特定用户的所有购物车项
    List<CartItem> getCartItemList(User user);
    //删除特定的购物车项
    void delCartItem(CartItem cartItem);

}
