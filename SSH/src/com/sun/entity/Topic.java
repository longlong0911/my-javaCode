package com.sun.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("serial")
//主题类
public class Topic extends Article implements Serializable{
	public 	static final int type_normal = 0;
	public  static final int type_best = 1;
	public  static final int type_top = 2;
	
	private Forum forum;   //版块
	private Set<Reply> replies = new HashSet<Reply>();  //回帖
	
	private int type;//类型
	private int replyCount;
	private Date lastUpdateTime;
	private Reply lastReply;

	
	
	public Forum getForum() {
		return forum;
	}
	public void setForum(Forum forum) {
		this.forum = forum;
	}
	public Set<Reply> getReplies() {
		return replies;
	}
	public void setReplies(Set<Reply> replies) {
		this.replies = replies;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}
	public Reply getLastReply() {
		return lastReply;
	}
	public void setLastReply(Reply lastReply) {
		this.lastReply = lastReply;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public static int getTypeNormal() {
		return type_normal;
	}
	public static int getTypeBest() {
		return type_best;
	}
	public static int getTypeTop() {
		return type_top;
	}
	
	
	
	
}
