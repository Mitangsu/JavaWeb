package controller;

import pojo.Topic;
import pojo.UserBasic;
import service.TopicService;
import service.UserBasicService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author shkstart
 * @create 2022-03-20 15:06
 */
public class UserController {

    private UserBasicService userBasicService ;
    private TopicService topicService ;

    public String login(String loginId , String pwd , HttpSession session){
        //1.登录验证
        UserBasic userBasic = userBasicService.login(loginId, pwd);
        if(userBasic!=null){
            //1-1 获取相关的好友信息
            List<UserBasic> friendList = userBasicService.getFriendList(userBasic);
            //1-2 获取相关的日志列表信息(但是，日志只有id，没有其他信息）
            List<Topic> topicList = topicService.getTopicList(userBasic);

            userBasic.setFriendList(friendList);
            userBasic.setTopicList(topicList);

            session.setAttribute("userBasic",userBasic);
            return "index";
        }else{
            return "login";
        }
    }
}
