package com.cskaoyan.crm.staff.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.cskaoyan.crm.staff.dao.StaffDao;
import com.cskaoyan.crm.staff.domain.CrmStaff;
import com.cskaoyan.crm.staff.service.StaffService;
import com.cskaoyan.crm.utils.StringUtils;

public class StaffServiceImpl implements StaffService {
	
	private StaffDao staffDao;
	public void setStaffDao(StaffDao staffDao) {
		this.staffDao = staffDao;
	}

	@Override
	public CrmStaff login(CrmStaff crmStaff) {
		// 要求MD5加密
		String loginPwd = crmStaff.getLoginPwd();
		loginPwd = StringUtils.getMD5Value(loginPwd);
		return staffDao.find(crmStaff.getLoginName(), loginPwd);
	}

	@Override
	public List<CrmStaff> findAll() {
		return staffDao.findAll();
	}
	
	@Override
	public List<CrmStaff> findAll(CrmStaff crmStaff) {
		
		StringBuilder builder = new StringBuilder();
		List<Object> paramsList = new ArrayList<Object>();
		// 1.1 部门
		if(crmStaff.getCrmPost() != null && crmStaff.getCrmPost().getCrmDepartment() != null){
			if(org.apache.commons.lang3.StringUtils.isNotBlank(crmStaff.getCrmPost().getCrmDepartment().getDepId())){
				builder.append(" and crmPost.crmDepartment.depId = ? ");
				paramsList.add(crmStaff.getCrmPost().getCrmDepartment().getDepId());
			}
		}
		// 1.2 职务
		if(crmStaff.getCrmPost() != null){
			if(org.apache.commons.lang3.StringUtils.isNotBlank(crmStaff.getCrmPost().getPostId())){
				builder.append(" and crmPost.postId = ? ");
				paramsList.add(crmStaff.getCrmPost().getPostId());
			}
		} 
		// 1.3 用户名
		if(org.apache.commons.lang3.StringUtils.isNotBlank(crmStaff.getStaffName())){
			builder.append(" and staffName = ? ");
			paramsList.add(crmStaff.getStaffName());
		}
		
		// 2 转换数据
		String condition = builder.toString();
		Object[] params = paramsList.toArray();
		
		return staffDao.findAll(condition, params);
	}

	@Override
	public void updatePassword(String staffId, String newPassword) {
		String loginPwd = StringUtils.getMD5Value(newPassword);
		CrmStaff crmStaff = staffDao.findById(staffId);
		crmStaff.setLoginPwd(loginPwd);
	}

	@Override
	public CrmStaff findById(String staffId) {
		return staffDao.findById(staffId);
	}

	@Override
	/**
	 * TODO 1.讨论如何实现更合理（管理员帮助员工修改密码）
	 */
	public void updateStaff(CrmStaff crmStaff) {
		//如果修改密码了，进行加密（依据：加密后的位数是32）
		String loginPwd = crmStaff.getLoginPwd();
		if(loginPwd.length() != 32){
			loginPwd = StringUtils.getMD5Value(loginPwd);
			crmStaff.setLoginPwd(loginPwd);
		}
		this.staffDao.update(crmStaff);
	}

	@Override
	public void addStaff(CrmStaff crmStaff) {
		// 要求MD5加密
		String loginPwd = crmStaff.getLoginPwd();
		loginPwd = StringUtils.getMD5Value(loginPwd);
		crmStaff.setLoginPwd(loginPwd);
		
		this.staffDao.save(crmStaff);
	}


}
