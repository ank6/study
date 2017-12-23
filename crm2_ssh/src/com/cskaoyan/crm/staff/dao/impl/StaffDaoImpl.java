package com.cskaoyan.crm.staff.dao.impl;

import java.util.List;

import com.cskaoyan.crm.base.impl.BaseDaoImpl;
import com.cskaoyan.crm.staff.dao.StaffDao;
import com.cskaoyan.crm.staff.domain.CrmStaff;

public class StaffDaoImpl extends BaseDaoImpl<CrmStaff> implements StaffDao{

	@Override
	@SuppressWarnings("unchecked")
	public CrmStaff find(String loginName, String loginPwd) {
		List<CrmStaff> allUser = this.getHibernateTemplate().find("from CrmStaff where loginName = ? and loginPwd = ?", loginName,loginPwd);
		if(allUser != null && allUser.size() > 0){
			return allUser.get(0);
		}
		return null;
	}

}
