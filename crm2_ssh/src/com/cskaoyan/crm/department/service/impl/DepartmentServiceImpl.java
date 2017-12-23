package com.cskaoyan.crm.department.service.impl;

import java.util.List;

import com.cskaoyan.crm.department.dao.DepartmentDao;
import com.cskaoyan.crm.department.domain.CrmDepartment;
import com.cskaoyan.crm.department.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentDao departmentDao;
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	
	@Override
	public List<CrmDepartment> findAll() {
		return departmentDao.findAll();
	}

	@Override
	public void addOrEdit(CrmDepartment crmDepartment) {
		departmentDao.saveOrUpdate(crmDepartment);
	}

	@Override
	public CrmDepartment findById(String depId) {
		return departmentDao.findById(depId);
	}

}
