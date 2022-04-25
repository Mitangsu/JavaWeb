package dao;

import org.omg.PortableInterceptor.INACTIVE;
import pojo.Topic;
import pojo.UserBasic;

import java.util.List;

/**
 * @author shkstart
 * @create 2022-03-20 12:22
 */
public interface TopicDAO {
    //获取指定用户的日志列表
    public List<Topic> getTopicList(UserBasic userBasic);
    //添加日志
    public void addTopic(Topic topic);
    //删除日志
    void delTopic(Topic topic);
    //获取特定日志信息
    Topic getTopic(Integer id);
}
