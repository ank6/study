package com.cskaoyan.crm.follow.service.impl;

import com.cskaoyan.crm.follow.dao.FollowDao;
import com.cskaoyan.crm.follow.domain.CrmFollow;
import com.cskaoyan.crm.follow.service.FollowService;

public class FollowServiceImpl implements FollowService {
	
	private FollowDao followDao;
	public void setFollowDao(FollowDao followDao) {
		this.followDao = followDao;
	}
	
	public void addOrEdit(CrmFollow crmFollow){
		this.followDao.saveOrUpdate(crmFollow);
	}

	@Override
	public CrmFollow findById(String followId) {
		return this.followDao.findById(followId);
	}

}
