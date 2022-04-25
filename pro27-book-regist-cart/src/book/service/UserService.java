package book.service;

import book.pojo.User;

/**
 * @author shkstart
 * @create 2022-03-24 9:13
 */
public interface UserService {
    User login(String uname,String pwd);
    void regist(User user);
    User getUser(String uname);
}
