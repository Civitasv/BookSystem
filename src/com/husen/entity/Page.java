package com.husen.entity;

public class Page {
	//一页里面的个数
	private int pageSize;
	//总页数
	private int totalPage;
	//总共的记录数
	private int totalCount;
	//当前页数
	private int currentPage;
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		return totalPage = totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	
}
