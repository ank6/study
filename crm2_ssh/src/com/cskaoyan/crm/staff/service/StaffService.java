package com.cskaoyan.crm.staff.service;

import java.util.List;

import com.cskaoyan.crm.staff.domain.CrmStaff;

public interface StaffService {
	
	/**
	 * 用户登录
	 * @param crmUser 登录信息
	 * @return
	 */
	public CrmStaff login(CrmStaff crmStaff);

	/**
	 * 查询所有用户
	 * @return
	 */
	public List<CrmStaff> findAll();
	
	/**
	 * 条件查询
	 * @param crmStaff
	 * @return
	 */
	public List<CrmStaff> findAll(CrmStaff crmStaff);

	/**
	 * 修改密码
	 * @param staffId
	 * @param newPassword
	 */
	public void updatePassword(String staffId, String newPassword);

	
	/**
	 * 通过id查询
	 * @param staffId
	 * @return
	 */
	public CrmStaff findById(String staffId);

	/**
	 * 更新用户信息
	 * @param crmStaff
	 */
	public void updateStaff(CrmStaff crmStaff);

	/**
	 * 添加
	 * @param crmStaff
	 */
	public void addStaff(CrmStaff crmStaff);

}
