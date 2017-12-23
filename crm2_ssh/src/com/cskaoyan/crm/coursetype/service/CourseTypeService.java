package com.cskaoyan.crm.coursetype.service;

import java.util.List;

import com.cskaoyan.crm.coursetype.domain.CrmCourseType;

public interface CourseTypeService {

	/**
	 * 查询所有
	 * @return
	 */
	List<CrmCourseType> findAll();

	/**
	 * 保存或更新
	 * @param crmCourseType
	 */
	void addOrEdit(CrmCourseType crmCourseType);

	/**
	 * 通过id查询
	 * @param courseTypeId
	 * @return
	 */
	CrmCourseType findById(String courseTypeId);
	
	/**
	 * 查询带有条件的所有
	 * @param crmCourseType 所有条件
	 * @return
	 */
	List<CrmCourseType> findAll(CrmCourseType crmCourseType);
}
