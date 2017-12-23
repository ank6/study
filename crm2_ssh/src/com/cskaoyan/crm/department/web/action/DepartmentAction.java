package com.cskaoyan.crm.department.web.action;

import java.util.List;

import com.cskaoyan.crm.base.BaseAction;
import com.cskaoyan.crm.department.domain.CrmDepartment;

public class DepartmentAction extends BaseAction<CrmDepartment> {

	private static final long serialVersionUID = 6202379891993594521L;

	/**
	 * 查询所有
	 * @return
	 */
	public String findAll(){
		List<CrmDepartment> allDepartment = this.getDepartmentService().findAll();
		this.set("allDepartment", allDepartment);
		return "findAll";
	}
	
	/**
	 * 编辑或添加 前
	 * @return
	 */
	public String preAddOrEdit(){
		if(this.getModel().getDepId() != null){
			CrmDepartment findDepartment = this.getDepartmentService().findById(this.getModel().getDepId());
			this.push(findDepartment);
		}
		return "preAddOrEdit";
	}
	
	/**
	 * 添加或编辑
	 * @return
	 */
	public String addOrEdit(){
		this.getDepartmentService().addOrEdit(this.getModel());
		return "addOrEdit";
	}
	
}
