package com.cskaoyan.crm.department.service;

import java.util.List;

import com.cskaoyan.crm.department.domain.CrmDepartment;

public interface DepartmentService {

	/**
	 * 查询所有部门
	 * @return
	 */
	List<CrmDepartment> findAll();

	/**
	 * 添加或编辑
	 * @param crmDepartment
	 */
	void addOrEdit(CrmDepartment crmDepartment);

	/**
	 * 通过id查询
	 * @param depId
	 * @return
	 */
	CrmDepartment findById(String depId);

}
