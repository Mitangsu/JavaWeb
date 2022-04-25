package book.impl;

import book.DAO.UserDAO;
import book.pojo.User;
import book.service.UserService;

/**
 * @author shkstart
 * @create 2022-03-24 9:14
 */
public class UserServiceImpl implements UserService {


    private UserDAO userDAO ;

    @Override
    public User login(String uname, String pwd) {
        return userDAO.getUser(uname,pwd);
    }

    @Override
    public void regist(User user) {
        userDAO.addUser(user);
    }

    @Override
    public User getUser(String uname) {
        return userDAO.getUser(uname);
    }
}
