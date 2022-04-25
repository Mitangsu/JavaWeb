package service;

import pojo.Topic;
import pojo.UserBasic;

import java.util.List;

/**
 * @author shkstart
 * @create 2022-03-20 14:58
 */
public interface TopicService {
    //查询特定用户的日志列表
    List<Topic> getTopicList(UserBasic userBasic);
}
