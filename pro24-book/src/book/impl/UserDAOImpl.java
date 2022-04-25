package book.impl;

import book.DAO.UserDAO;
import book.pojo.User;
import com.atguigu.myssm.basedao.BaseDAO;

/**
 * @author shkstart
 * @create 2022-03-24 9:12
 */
public class UserDAOImpl extends BaseDAO<User> implements UserDAO{

    @Override
    public User getUser(String uname, String pwd) {
        return load("select * from t_user where uname like ? and pwd like ?",uname,pwd);
    }
}
