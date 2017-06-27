package com.sun.entity;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Article implements Serializable{
	private Long id;
	private String title;
	private String content;
	private String faceIcon;
	
	private User author;
	private String ipAddr;
	private Date postTime;

	

	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFaceIcon() {
		return faceIcon;
	}
	public void setFaceIcon(String faceIcon) {
		this.faceIcon = faceIcon;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public String getIpAddr() {
		return ipAddr;
	}
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
	public Date getPostTime() {
		return postTime;
	}
	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}
	
	
	
	
	
}
