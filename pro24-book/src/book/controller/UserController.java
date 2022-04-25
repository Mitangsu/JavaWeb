package book.controller;

import book.pojo.User;
import book.service.UserService;

/**
 * @author shkstart
 * @create 2022-03-24 9:09
 */
public class UserController {

    private UserService userService;




    public String login(String uname,String pwd){

        User user = userService.login(uname, pwd);

        System.out.println("user=" + user);
        return "index";
    }
}
