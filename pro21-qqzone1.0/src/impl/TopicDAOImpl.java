package impl;

import dao.TopicDAO;
import myssm.basedao.BaseDAO;
import pojo.Topic;
import pojo.UserBasic;

import java.util.List;

/**
 * @author shkstart
 * @create 2022-03-20 14:40
 */
public class TopicDAOImpl extends BaseDAO<Topic> implements TopicDAO {
    @Override
    public List<Topic> getTopicList(UserBasic userBasic) {
        return super.executeQuery("select * from t_topic where author = ? ",userBasic.getId());
    }

    @Override
    public void addTopic(Topic topic) {

    }

    @Override
    public void delTopic(Topic topic) {

    }

    @Override
    public Topic getTopic(Integer id) {
        return null;
    }
}
