package com.cskaoyan.crm.post.dao.impl;

import java.util.List;

import com.cskaoyan.crm.base.impl.BaseDaoImpl;
import com.cskaoyan.crm.post.dao.PostDao;
import com.cskaoyan.crm.post.domain.CrmPost;

public class PostDaoImpl extends BaseDaoImpl<CrmPost> implements PostDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<CrmPost> findAll(String depId) {
		return this.getHibernateTemplate().find("from CrmPost p where p.crmDepartment.depId = ?" , depId);
	}

}
