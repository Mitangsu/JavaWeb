package dao;

import pojo.Reply;
import pojo.Topic;

import java.util.List;

/**
 * @author shkstart
 * @create 2022-03-20 12:24
 */
public interface ReplyDAO {
    //获取指定日志的回复列表
    List<Reply> getReplyList(Topic topic);
    //添加回复
    void addReply(Reply reply);
    //删除回复
    void delReply(Integer id);
}
