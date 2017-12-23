package com.cskaoyan.crm.coursetype.web.action;

import java.util.List;

import com.cskaoyan.crm.base.BaseAction;
import com.cskaoyan.crm.coursetype.domain.CrmCourseType;

public class CourseTypeAction extends BaseAction<CrmCourseType> {

	private static final long serialVersionUID = 7511941992883092132L;

	/**
	 * 查询所有
	 * @return
	 */
	public String findAll(){
		//1查询所有
		List<CrmCourseType> allCourseType = this.getCourseTypeService().findAll(this.getModel());
		//2存放值栈中
		this.set("allCourseType", allCourseType);
		return "findAll";
	}
	
	/**
	 * 编辑前操作，通过id查询课程类别，但如果是添加将没有id值
	 * @return
	 */
	public String preAddOrEdit(){
		if(this.getModel().getCourseTypeId() != null){
			//update操作--需要查询
			CrmCourseType findLessontype = this.getCourseTypeService().findById(this.getModel().getCourseTypeId());
			// 存放到值栈中 , 存放到context，jsp必须“#key”获得,但标签回显不容易
			//this.put("findLessontype",findLessontype);
			// *** 应该让struts自动进行回显，默认从栈顶开始获得数据
			this.push(findLessontype);
		}
		return "preAddOrEdit";
	}
	
	/**
	 * 编辑操作
	 * @return
	 */
	public String addOrEdit(){
		this.getCourseTypeService().addOrEdit(this.getModel());
		return "addOrEdit";
	}

	
}
