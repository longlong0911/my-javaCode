package com.sun.entity;

import java.util.ArrayList;
import java.util.List;

public class PageBean {
	private int currentPage;
	private int pageAllCount;
	private int pageAllSize;
	private int startNumber;
	private int endNumber;
	private List<Reply> currentPageList = new ArrayList<Reply>();

	public PageBean(int currentPage, int pageAllCount,
			List<Reply> currentPageList) {
		super();
		this.currentPage = currentPage;
		this.pageAllCount = pageAllCount;
		this.currentPageList = currentPageList;

		pageAllSize = (pageAllCount+4)/5;
		if(pageAllSize<5){
			startNumber = 1;
			endNumber = pageAllSize;
		}else{
			startNumber = currentPage-2;
			endNumber = currentPage+2;
			if((currentPage-2)<0){
				startNumber = 1;
				endNumber = 5;
			}else if( (currentPage+2) > pageAllSize ){
				startNumber = pageAllSize-4;
				endNumber = pageAllSize;
			}
		}
		
		
		
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageAllCount() {
		return pageAllCount;
	}
	public void setPageAllCount(int pageAllCount) {
		this.pageAllCount = pageAllCount;
	}
	public int getPageAllSize() {
		return pageAllSize;
	}
	public void setPageAllSize(int pageAllSize) {
		this.pageAllSize = pageAllSize;
	}
	public List<Reply> getCurrentPageList() {
		return currentPageList;
	}
	public void setCurrentPageList(List<Reply> currentPageList) {
		this.currentPageList = currentPageList;
	}
	public int getStartNumber() {
		return startNumber;
	}
	public void setStartNumber(int startNumber) {
		this.startNumber = startNumber;
	}
	public int getEndNumber() {
		return endNumber;
	}
	public void setEndNumber(int endNumber) {
		this.endNumber = endNumber;
	}
	
	
	
	
	
}
