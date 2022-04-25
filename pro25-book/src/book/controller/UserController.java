package book.controller;

import book.pojo.Book;
import book.pojo.Cart;
import book.pojo.User;
import book.service.BookService;
import book.service.CartItemService;
import book.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author shkstart
 * @create 2022-03-24 9:09
 */
public class UserController {

    private UserService userService;
    private CartItemService cartItemService;


    public String login(String uname, String pwd, HttpSession session){
        User user = userService.login(uname, pwd);
        if (user != null){
            Cart cart = cartItemService.getCart(user);
            user.setCart(cart);
            session.setAttribute("currUser",user);
            return "redirect:book.do";
        }
        return "user/login";
    }
}
