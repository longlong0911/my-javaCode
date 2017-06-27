package com.sun.serviceIpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sun.base.BaseDaoIpl;
import com.sun.entity.Forum;
import com.sun.entity.Topic;
import com.sun.serviceI.TopicServiceI;

@SuppressWarnings("unchecked")
@Service
public class TopicServiceIpl extends BaseDaoIpl<Topic> implements TopicServiceI{

	public List<Topic> findByForum(Forum forum) {
		// 需要考虑排序三种类型的主题
		
		return getSession()
				.createQuery("from Topic t where t.forum=? order by (case t.type when 2 then 2 else 0 end) desc,t.lastUpdateTime desc")
				.setParameter(0,forum)
				.list();
	}
	
	@Override
	public void save(Topic topic) {
		//设置属性并保存
//		topic.setType(topic.type_normal);
//		topic.setReplyCount(0);
//		topic.setLastReply(null);//默认值可以不写
		topic.setLastUpdateTime(topic.getPostTime());
		getSession().save(topic);
		//维护相关信息
		//主题数 文章数 最后发表的主题
		Forum forum = topic.getForum();
		forum.setTopicCount(forum.getTopicCount() + 1);
		forum.setArticleCount(forum.getArticleCount() + 1);
		forum.setLastTopic(topic);
		getSession().update(forum);
		
	}
}
