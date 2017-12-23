package com.cskaoyan.crm.coursetype.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.cskaoyan.crm.coursetype.dao.CourseTypeDao;
import com.cskaoyan.crm.coursetype.domain.CrmCourseType;
import com.cskaoyan.crm.coursetype.service.CourseTypeService;

public class CourseTypeServiceImpl implements CourseTypeService {

	private CourseTypeDao courseTypeDao;
	public void setCourseTypeDao(CourseTypeDao courseTypeDao) {
		this.courseTypeDao = courseTypeDao;
	}
	
	@Override
	public List<CrmCourseType> findAll() {
		return this.courseTypeDao.findAll();
	}
	
	@Override
	public void addOrEdit(CrmCourseType crmCourseType) {
		this.courseTypeDao.saveOrUpdate(crmCourseType);
	}
	
	@Override
	public CrmCourseType findById(String courseTypeId) {
		return this.courseTypeDao.findById(courseTypeId);
	}


	@Override
	public List<CrmCourseType> findAll(CrmCourseType crmCourseType) {
		// 1 拼凑条件
		StringBuilder builder = new StringBuilder();
		List<Object> paramsList = new ArrayList<Object>();	//有序，可重复的
		
		// 2 条件
		// 2.1 类别名称
		if(StringUtils.isNotBlank(crmCourseType.getCourseName())){
			builder.append(" and courseName like ? ");
			paramsList.add("%"+crmCourseType.getCourseName()+"%");
		}
		// 2.2 简介
		if(StringUtils.isNotBlank(crmCourseType.getRemark())){
			builder.append(" and remark like ? ");
			paramsList.add("%"+crmCourseType.getRemark()+"%");
		}
		
		// 2.3 学时范围，类型:int
		if(StringUtils.isNotBlank(crmCourseType.getTotalStart())){
			builder.append(" and total >= ? ");
			paramsList.add(Integer.parseInt(crmCourseType.getTotalStart()));
		}
		
		if(StringUtils.isNotBlank(crmCourseType.getTotalEnd())){
			builder.append(" and total <= ? ");
			paramsList.add(Integer.parseInt(crmCourseType.getTotalEnd()));
		}
		// 2.4 课程范围，类型:double
		if(StringUtils.isNotBlank(crmCourseType.getLessonCostStart())){
			builder.append(" and lessonCost >= ? ");
			paramsList.add(Double.parseDouble(crmCourseType.getLessonCostStart()));
		}
		
		if(StringUtils.isNotBlank(crmCourseType.getLessonCostEnd())){
			builder.append(" and lessonCost <= ? ");
			paramsList.add(Double.parseDouble(crmCourseType.getLessonCostEnd()));
		}
		
		
		//3 使用
		
		String condition = builder.toString();
		Object[] params = paramsList.toArray();
		
		return this.courseTypeDao.findAll(condition, params);
	}

}
