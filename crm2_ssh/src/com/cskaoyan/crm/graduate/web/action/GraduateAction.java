package com.cskaoyan.crm.graduate.web.action;

import java.util.List;

import com.cskaoyan.crm.base.BaseAction;
import com.cskaoyan.crm.classesm.domain.CrmClass;
import com.cskaoyan.crm.graduate.domain.CrmGraduate;

public class GraduateAction extends BaseAction<CrmGraduate> {

	private static final long serialVersionUID = -2334493484434671390L;
	
	/**
	 * 查询所有
	 * @return
	 */
	public String findAll(){
		
		//2查询所有
		List<CrmGraduate> allGraduate = this.getGraduateService().findAll();
		this.set("allGraduate", allGraduate);
		
		return "findAll";
	}
	
	/**
	 * 添加或编辑前
	 * @return
	 */
	public String preAddOrEdit(){
		//1查询所有的班级
		List<CrmClass> allClass = this.getClassService().findAll();
		this.set("allClass", allClass);
		
		return "preAddOrEdit";
	}
	
	/**
	 * 添加或编辑
	 * @return
	 */
	public String addOrEdit(){
		this.getGraduateService().addOrEdit(this.getModel());
		return "addOrEdit";
	}

}
