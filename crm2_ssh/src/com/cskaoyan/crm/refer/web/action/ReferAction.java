package com.cskaoyan.crm.refer.web.action;

import java.util.Date;
import java.util.List;

import com.cskaoyan.crm.base.BaseAction;
import com.cskaoyan.crm.constant.CommonConstant;
import com.cskaoyan.crm.coursetype.domain.CrmCourseType;
import com.cskaoyan.crm.refer.domain.CrmRefer;
import com.cskaoyan.crm.staff.domain.CrmStaff;

public class ReferAction extends BaseAction<CrmRefer> {
	private static final long serialVersionUID = -1455503171188058558L;
	
	
	/**
	 * 查询所有
	 * @return
	 */
	public String findAll(){
		List<CrmRefer> allRefer = this.getReferService().findAll(this.getModel());
		this.set("allRefer", allRefer);
		//this.set("condition", condition);
		return "findAll";
	}
	
	/**
	 * 添加或编辑 前
	 * @return
	 */
	public String preAddOrEdit(){
		
		// 1 查询所有的课程类别
		List<CrmCourseType> allCourseType = this.getCourseTypeService().findAll();
		this.put("allCourseType", allCourseType);
		
		// 查询指定id的资讯
		if(this.getModel().getReferId() != null){
			CrmRefer findRefer = this.getReferService().findById(this.getModel().getReferId());
			this.push(findRefer);
		}
		return "preAddOrEdit";
	}
	
	/**
	 * 添加或编辑
	 * @return
	 */
	public String addOrEdit(){	
		if(this.getModel().getReferId() == null){
			this.getModel().setCreateDate(new Date());
			CrmStaff crmStaff = (CrmStaff) this.sessionGet("loginUser");
			this.getModel().setCrmStaff(crmStaff);
			// 注意状态
			this.getModel().setStatus(CommonConstant.REFER_STATUS_DEFAULT);
		}
		this.getReferService().addOrEdit(this.getModel());
		return "addOrEdit";
	}
	
	/**
	 * 通过id查询
	 * @return
	 */
	public String findById(){
		CrmRefer findRefer = this.getReferService().findById(this.getModel().getReferId());
		this.push(findRefer);
		return "findById";
	}
	
	/**
	 * 添加前
	 * @return
	 */
	public String preAdd(){
		
		// 1 查询所有的课程类别
		List<CrmCourseType> allCourseType = this.getCourseTypeService().findAll();
		this.put("allCourseType", allCourseType);
		
		return "preAdd";
	}
	
	/**
	 * 添加
	 * @return
	 */
	public String add(){	
		this.getModel().setCreateDate(new Date());
		CrmStaff crmStaff = (CrmStaff) this.sessionGet("loginUser");
		this.getModel().setCrmStaff(crmStaff);
		// 注意状态
		this.getModel().setStatus(CommonConstant.REFER_STATUS_DEFAULT);
		
		this.getReferService().addRefer(this.getModel());
		return "add";
	}
	/**
	 * 编辑前
	 * @return
	 */
	public String preEdit(){
		
		// 1 查询所有的课程类别
		List<CrmCourseType> allCourseType = this.getCourseTypeService().findAll();
		this.put("allCourseType", allCourseType);
		
		// 2 查询指定id的资讯
		CrmRefer findRefer = this.getReferService().findById(this.getModel().getReferId());
		this.push(findRefer);
		
		return "preEdit";
	}
	
	/**
	 * 编辑
	 * @return
	 */
	public String edit(){	
		this.getReferService().updateRefer(this.getModel());
		return "edit";
	}
	
	/**
	 * 入学编班前
	 * @return
	 */
	public String preAddStudent(){
		// 查询指定id的资讯
		CrmRefer findRefer = this.getReferService().findById(this.getModel().getReferId());
		this.push(findRefer);
		return "preAddStudent";
	}
	
	/**
	 * 入学编班 通过chain 到添加学生操作
	 * @return
	 */
	public String addStudent(){
		return "addStudent";
	}
	
}
