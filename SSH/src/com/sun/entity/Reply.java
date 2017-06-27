package com.sun.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Reply extends Article implements Serializable{
	private Topic topic;

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	

}
