package book.service;

import book.pojo.Cart;
import book.pojo.CartItem;
import book.pojo.User;

import java.util.List;

/**
 * @author shkstart
 * @create 2022-03-24 22:07
 */
public interface CartItemService {
    void addCartItem(CartItem cartItem);
    void updateCartItem(CartItem cartItem);
    void addOrUpdateCartItem(CartItem cartItem, Cart cart);

    //获取指定用户的所有购物车项列表(需要主要的是,这个方法内部查询的时候,会将book的详细信息设置进去)
    List<CartItem> getCartItemList(User user);
    //加载特点用户的购物车信息
    Cart getCart(User user);
}
