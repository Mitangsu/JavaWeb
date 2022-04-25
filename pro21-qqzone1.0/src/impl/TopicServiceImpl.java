package impl;

import dao.TopicDAO;
import pojo.Topic;
import pojo.UserBasic;
import service.TopicService;

import java.util.List;

/**
 * @author shkstart
 * @create 2022-03-20 14:59
 */
public class TopicServiceImpl implements TopicService {

    private TopicDAO topicDAO = null ;

    @Override
    public List<Topic> getTopicList(UserBasic userBasic) {
        return topicDAO.getTopicList(userBasic);
    }
}
