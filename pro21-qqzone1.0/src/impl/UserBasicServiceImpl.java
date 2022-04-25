package impl;

import dao.UserBasicDAO;
import pojo.UserBasic;
import service.UserBasicService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 2022-03-20 14:44
 */
public class UserBasicServiceImpl implements UserBasicService{

    private UserBasicDAO userBasicDAO = null;


    @Override
    public UserBasic login(String loginID, String pwd) {
        UserBasic userBasic = userBasicDAO.getUserBasic(loginID, pwd);

        return userBasic;
    }

    @Override//左侧好友列表
    public List<UserBasic> getFriendList(UserBasic userBasic) {
        List<UserBasic> userBasicList = userBasicDAO.getUserBasicList(userBasic);
        List<UserBasic> friendList = new ArrayList<>(userBasicList.size());
        for (int i = 0; i < userBasicList.size(); i++) {
            UserBasic friend = userBasicList.get(i);
            friend = userBasicDAO.getUserBasicById(friend.getId());
            friendList.add(friend);


        }
        return friendList;
    }
}
