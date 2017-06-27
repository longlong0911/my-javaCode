package com.sun.action;

import java.util.Date;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.sun.base.BaseAction;
import com.sun.entity.Forum;
import com.sun.entity.PageBean;
import com.sun.entity.Topic;
@Controller
@Scope("prototype")
public class TopicAction extends BaseAction<Topic>{
	
	private Long forumId;
	
	
	//显示单个主题（主贴+回复）
	public String show() throws Exception {
		//准备topic
		Topic topic = topicService.findById(model.getId());
		ActionContext.getContext().put("topic",topic);
		//准备reply
//		List<Reply> replyList = replyService.findByTopic(topic);
//		ActionContext.getContext().put("replyList",replyList);
		PageBean pageBean = replyService.findPageBean(currentPage,topic);
		ActionContext.getContext().getValueStack().push(pageBean);
		
		
		return "show";
	}
	
	//发表新主题页面
	public String addUI() throws Exception {
		//准备数据
		Forum forum = forumService.findById(forumId);
		ActionContext.getContext().put("forum",forum);
		return "addUI";
	}
	//保存新主题
	public String add() throws Exception {
		//封装
		//表单中的字段 已经封装了title content faceicon
//		model.setTitle(title);
//		model.setContent(content);
//		model.setFaceIcon(faceIcon);
		model.setForum(forumService.findById(forumId));

		model.setAuthor(getCurrentUser());
		model.setPostTime(new Date()); //当前时间
		//当前可直接获得的信息
		model.setIpAddr(ServletActionContext.getRequest().getRemoteAddr());
		//应放到业务方法中的一个其他设置
//		model.setLastReply(lastReply);
//		model.setLastUpdateTime(lastUpdateTime);
//		model.setReplyCount(replyCount);
//		model.setType(type);
		
		topicService.save(model);
		//保存
		
		return "toShow";//转到当前发表的主题页面
	}

	//===========================
	
	public Long getForumId() {
		return forumId;
	}
	
	public void setForumId(Long forumId) {
		this.forumId = forumId;
	}
	private int currentPage=1;


	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	
	
}
