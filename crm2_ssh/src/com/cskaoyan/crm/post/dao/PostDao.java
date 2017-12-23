package com.cskaoyan.crm.post.dao;

import java.util.List;

import com.cskaoyan.crm.base.BaseDao;
import com.cskaoyan.crm.post.domain.CrmPost;

public interface PostDao extends BaseDao<CrmPost>  {

	/**
	 * 通过部门id查询职务
	 * @param depId
	 * @return
	 */
	List<CrmPost> findAll(String depId);

}
