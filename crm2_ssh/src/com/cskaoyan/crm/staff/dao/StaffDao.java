package com.cskaoyan.crm.staff.dao;

import com.cskaoyan.crm.base.BaseDao;
import com.cskaoyan.crm.staff.domain.CrmStaff;

public interface StaffDao extends BaseDao<CrmStaff> {
	/**
	 * 通过 登录名 和密码 查询用户
	 * @param loginName 登录名
	 * @param loginPwd 登录密码
	 * @return
	 */
	public CrmStaff find(String loginName,String loginPwd);

}
