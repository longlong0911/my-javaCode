package com.sun.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Privilege implements Serializable{
	
	private Long id;
	private String name;
	private String url;
	
	private Privilege parent;
	private Set<Privilege> children = new HashSet<Privilege>();
	private Set<Post> posts = new HashSet<Post>();
	
	public Privilege(){
		
	}
	public Privilege(String name, String url, Privilege parent) {
		super();
		this.name = name;
		this.url = url;
		this.parent = parent;
	}

	
	
	
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Privilege getParent() {
		return parent;
	}
	public void setParent(Privilege parent) {
		this.parent = parent;
	}
	public Set<Privilege> getChildren() {
		return children;
	}
	public void setChildren(Set<Privilege> children) {
		this.children = children;
	}
	public Set<Post> getPosts() {
		return posts;
	}
	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}
	
}
