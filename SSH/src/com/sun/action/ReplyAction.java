package com.sun.action;

import java.util.Date;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.sun.base.BaseAction;
import com.sun.entity.Reply;
import com.sun.entity.Topic;
/**
 * @author Administrator
 *
 */
@Controller
@Scope("prototype")
public class ReplyAction extends BaseAction<Reply>{

	private Long topicId;
	public String addUI() throws Exception {
		Topic topic = topicService.findById(topicId);
		ActionContext.getContext().put("topic",topic);
		
		return "addUI";
	}
	public String add() throws Exception {
//		model.setTitle(title);
//		model.setFaceIcon(faceIcon);
//		model.setContent(content);
		
		model.setTopic(topicService.findById(topicId));
	
		model.setAuthor(getCurrentUser());
		model.setIpAddr(ServletActionContext.getRequest().getRemoteAddr());
		model.setPostTime(new Date());
		replyService.save(model);
		return "toTopicShow";//转到所属主题的显示页面
	}
	
	public String delete() throws Exception {
		replyService.delete(model.getId());
		return "toTopicShow";
	}
	//-----------------------------
	
	public Long getTopicId() {
		return topicId;
	}
	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}
	
}
