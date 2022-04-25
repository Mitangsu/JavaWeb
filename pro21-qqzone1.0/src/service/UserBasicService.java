package service;

import pojo.UserBasic;

import java.util.List;

/**
 * @author shkstart
 * @create 2022-03-20 14:44
 */
public interface  UserBasicService {

    UserBasic login(String loginID,String pwd);

    List<UserBasic> getFriendList(UserBasic userBasic);

}
