package com.cskaoyan.crm.follow.web.action;

import java.util.Date;

import com.cskaoyan.crm.base.BaseAction;
import com.cskaoyan.crm.follow.domain.CrmFollow;
import com.cskaoyan.crm.staff.domain.CrmStaff;

public class FollowAction extends BaseAction<CrmFollow> {

	private static final long serialVersionUID = -6362821775050123442L;
	
	public String preAddOrEdit(){
		if(this.getModel().getFollowId() != null){
			CrmFollow crmFollow = this.getFollowService().findById(this.getModel().getFollowId());
			this.push(crmFollow);
		}
		return "preAddOrEdit";
	}
	
	public String addOrEdit(){
		this.getModel().setFollowTime(new Date());
		CrmStaff crmStaff = (CrmStaff) this.sessionGet("loginUser");
		this.getModel().setCrmStaff(crmStaff);
		
		this.getFollowService().addOrEdit(this.getModel());
		return "addOrEdit";
	}

}
