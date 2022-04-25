package impl;

import dao.UserBasicDAO;
import myssm.basedao.BaseDAO;
import pojo.UserBasic;

import java.util.List;

/**
 * @author shkstart
 * @create 2022-03-20 12:29
 */
public class UserBasicDAOImpl extends BaseDAO<UserBasic> implements UserBasicDAO{

    @Override//根据账号和密码获取特定用户信息
    public UserBasic getUserBasic(String loginId, String pwd) {
        return super.load("select * from t_user_basic where loginId=? and pwd=?",loginId,pwd);
    }

    @Override//获取指定用户的所有好友列表
    public List<UserBasic> getUserBasicList(UserBasic userBasic) {
        String sql = "select fid as 'id' from t_friend where uid = ?";
        return super.executeQuery(sql,userBasic.getId());
    }

    @Override
    public UserBasic getUserBasicById(Integer id) {
        return load("select * from t_user_basic where id = ?",id);
    }
}
