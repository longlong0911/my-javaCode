package com.sun.serviceIpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sun.base.BaseDaoIpl;
import com.sun.entity.Forum;
import com.sun.serviceI.ForumServiceI;
@Service
@SuppressWarnings("unchecked")
public class ForumServiceIpl extends BaseDaoIpl<Forum> implements ForumServiceI{
	@Override
	public List<Forum> findAll() {
		return getSession()
				.createQuery("from Forum f order by f.position asc")
				.list();
	}
	@Override
	public void save(Forum entity) {
		getSession().save(entity);
		entity.setPosition(entity.getId().intValue());
	}
	public void moveUp(Long forumid) {
		//找到前面那个数的position
		Forum forum = (Forum) getSession().get(Forum.class,forumid);
		Forum other = (Forum) 
				getSession()
				.createQuery("from Forum f where f.position<? order by f.position desc ")
				.setParameter(0,forum.getPosition())
				.setFirstResult(0)
				.setMaxResults(1)
				.uniqueResult();
		
		//两个position交换
		int t = forum.getPosition();
		forum.setPosition(other.getPosition());
		other.setPosition(t);
		//保存 持久化状态不需要 update
		
	}
	public void moveDown(Long forumid) {
		//找到前面那个数的position
		Forum forum = (Forum) getSession().get(Forum.class,forumid);
		Forum other = (Forum) 
				getSession()
				.createQuery("from Forum f where f.position>? order by f.position ")
				.setParameter(0,forum.getPosition())
				.setFirstResult(0)
				.setMaxResults(1)
				.uniqueResult();
		
		//两个position交换
		int t = forum.getPosition();
		forum.setPosition(other.getPosition());
		other.setPosition(t);
		//保存 持久化状态不需要 update
		

	}
}
