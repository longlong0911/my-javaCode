package com.sun.serviceI;

import com.sun.base.BaseDaoI;
import com.sun.entity.Forum;

public interface ForumServiceI extends BaseDaoI<Forum>{

	void moveUp(Long forumid);

	void moveDown(Long forumid);

}
