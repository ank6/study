package com.cskaoyan.crm.follow.service;

import com.cskaoyan.crm.follow.domain.CrmFollow;

public interface FollowService {
	
	/**
	 * 添加或编辑
	 * @param crmFollow
	 */
	public void addOrEdit(CrmFollow crmFollow);

	/**
	 * 通过id查询
	 * @param followId
	 * @return
	 */
	public CrmFollow findById(String followId);

}
