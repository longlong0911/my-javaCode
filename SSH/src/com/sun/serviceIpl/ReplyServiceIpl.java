package com.sun.serviceIpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sun.base.BaseDaoIpl;
import com.sun.entity.Forum;
import com.sun.entity.PageBean;
import com.sun.entity.Reply;
import com.sun.entity.Topic;
import com.sun.serviceI.ReplyServiceI;

@SuppressWarnings("unchecked")
@Service
public class ReplyServiceIpl extends BaseDaoIpl<Reply> implements ReplyServiceI{

//	public List<Reply> findByTopic(Topic topic) {
//		//按最新的在最后面排序	
//		return getSession()
//				.createQuery("from Reply r where r.topic=? order by r.postTime asc")
//				.setParameter(0, topic).list();
//	}

	@Override
	public void save(Reply reply) {
		
		getSession().save(reply);
		
		Topic topic = reply.getTopic();
		Forum forum = topic.getForum();
		
		forum.setArticleCount(forum.getArticleCount()+1);
		topic.setReplyCount(topic.getReplyCount()+1);
		topic.setLastReply(reply);
		topic.setLastUpdateTime(reply.getPostTime());
		
		getSession().update(topic);
		getSession().update(forum);
		
	}

	public PageBean findPageBean(int currentPage, Topic topic) {
		
		List<Reply> currentPageList = getSession()
				.createQuery("from Reply r where r.topic=? order by r.postTime")
				.setParameter(0, topic)
				.setFirstResult((currentPage-1)*5)
				.setMaxResults(5)
				.list();
		for(Reply reply : currentPageList){
			System.out.println("============");
			System.out.println(reply.getContent());
		}
		Long pageAllCount =  (Long) getSession()
							.createQuery("select count(*) from Reply r where r.topic=?")
							.setParameter(0, topic)
							.uniqueResult();
		
		return new PageBean(currentPage, pageAllCount.intValue(), currentPageList);
		
	}
	
}
