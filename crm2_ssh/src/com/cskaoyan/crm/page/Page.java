package com.cskaoyan.crm.page;

import java.util.List;

/**
 * 分页 数据封装对象
 * @author  
 *
 * @param <T>
 */
public class Page<T> {
	// 必选项
	private int pageNum;			//当前页 -- 浏览器传递
	private int pageSize;			//每页显示个数 -- 固定值（浏览器传递）
	private int totalRecord;		//总记录数（数据库总条数） -- 查询数据库获得
	// 计算项
	private int startIndex;			//开始索引
	private int totalPage;			//总分页数
	// 分页数据
	private List<T> data;			//分页数据 --查询数据库获得
	// 导航动态显示条
	private int start;				//循环开始
	private int end;				//循环结束
	
	
	public Page(int pageNum, int pageSize, int totalRecord) {
		super();
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.totalRecord = totalRecord;
		
		// 0 优化 -- 排除负页
		if(this.pageNum < 1){
			this.pageNum = 1;
		}
		//1 计算项
		// 1.1  开始索引
		this.startIndex = (this.pageNum - 1) * this.pageSize; 
		// 1.2 总分页数
		this.totalPage = (this.totalRecord + this.pageSize - 1) / this.pageSize;
		//2 动态条 最多显示10分页，前4后5
		// 2.1 默认值
		this.start = 1;
		this.end = 10;
		// 2.2 处理
		// * 假设 totalPage = 4;
		if(this.totalPage <= 10){
			this.end = this.totalPage;
		} else {
			// 假设 totalPage = 35
			
			// * 前4后5
			this.start = this.pageNum - 4;
			this.end = this.pageNum + 5;
			
			// * pageNum = 1
			if(this.start < 1) {
				this.start = 1;
				this.end = 10;
			}
			
			// * pageNUm = 35
			if(this.end > this.totalPage){
				this.end = this.totalPage;
				this.start = this.totalPage - 9;
			}
			
		}
		
	}


	public int getPageNum() {
		return pageNum;
	}


	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public int getTotalRecord() {
		return totalRecord;
	}


	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}


	public int getStartIndex() {
		return startIndex;
	}


	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}


	public int getTotalPage() {
		return totalPage;
	}


	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}


	public List<T> getData() {
		return data;
	}


	public void setData(List<T> data) {
		this.data = data;
	}


	public int getStart() {
		return start;
	}


	public void setStart(int start) {
		this.start = start;
	}


	public int getEnd() {
		return end;
	}


	public void setEnd(int end) {
		this.end = end;
	}
	

}
