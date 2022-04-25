package book.DAO;

import book.pojo.User;

/**
 * @author shkstart
 * @create 2022-03-24 9:10
 */
public interface UserDAO {
    User getUser(String uname, String pwd);
}
