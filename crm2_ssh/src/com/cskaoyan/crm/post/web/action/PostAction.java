package com.cskaoyan.crm.post.web.action;

import java.util.List;

import com.cskaoyan.crm.base.BaseAction;
import com.cskaoyan.crm.department.domain.CrmDepartment;
import com.cskaoyan.crm.post.domain.CrmPost;

public class PostAction extends BaseAction<CrmPost> {
	
	private static final long serialVersionUID = -6311975880317481539L;
	
	/**
	 * 通过部门id，使用ajax查询职务
	 * @return
	 */
	public String ajaxGetPostion(){
		//获得部门id
		String depId = this.getModel().getCrmDepartment().getDepId();
		//通过部门id，查询所有职务
		List<CrmPost> allPost = this.getPostService().findAll(depId);
		// * 将查询结果存放值栈中 , jsp 通过“key”获得
		this.set("allPost", allPost);
		
		return "ajaxGetPostion";
	}
	
	/**
	 * 查询所有
	 * @return
	 */
	public String findAll(){
		List<CrmPost> allPost = this.getPostService().findAll();
		this.set("allPost", allPost);
		
		return "findAll";
	}
	
	/**
	 * 添加或编辑
	 * @return
	 */
	public String preAddOrEdit(){
		//1 查询当前职务（编辑）
		if(this.getModel().getPostId() != null){
			CrmPost findPost = this.getPostService().findById(this.getModel().getPostId());
			this.push(findPost);
		}
		// 2 查询所有部门
		List<CrmDepartment> allDepartment = this.getDepartmentService().findAll();
		// jsp 通过 "#key" 获得数据
		this.put("allDepartment", allDepartment);
		
		return "preAddOrEdit";
	}
	
	/**
	 * 添加或编辑
	 * @return
	 */
	public String addOrEdit(){
		this.getPostService().addOrEdit(this.getModel());
		return "addOrEdit";
	}
	
	
}
