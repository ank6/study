package com.cskaoyan.crm.classesm.service;

import java.util.List;

import com.cskaoyan.crm.classesm.domain.CrmClass;
import com.cskaoyan.crm.coursetype.domain.CrmCourseType;

public interface ClassService {

	/**
	 * 查询所有
	 * @return
	 */
	List<CrmClass> findAll();

	/**
	 * 通过id查询
	 * @param classId
	 * @return
	 */
	CrmClass findById(String classId);
	/**
	 * 添加或更新
	 * @param crmClass
	 */
	void addOrEdit(CrmClass crmClass);

	/**
	 * 查询指定类别，所有班级
	 * @param courseTypeId
	 * @return
	 */
	List<CrmClass> findAll(CrmCourseType courseType);

	/**
	 * 更新课表
	 * @param model
	 */
	void updateSchedule(CrmClass model);

}
