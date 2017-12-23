package com.cskaoyan.crm.runoff.web.action;

import java.util.Date;
import java.util.List;

import com.cskaoyan.crm.base.BaseAction;
import com.cskaoyan.crm.constant.CommonConstant;
import com.cskaoyan.crm.runoff.domain.CrmRunOff;
import com.cskaoyan.crm.staff.domain.CrmStaff;
import com.cskaoyan.crm.student.domain.CrmStudent;

public class RunoffAction extends BaseAction<CrmRunOff> {

	private static final long serialVersionUID = -6086249673293732228L;
	
	/**
	 * 添加前操作
	 * @return
	 */
	public String preAdd(){
		CrmStudent findStudent = this.getStudentService().findById(this.getModel().getCrmStudent().getStudentId());
		this.push(findStudent);
		return "preAdd";
	}
	
	/**
	 * 添加
	 * @return
	 */
	public String add(){
		CrmStaff crmStaff = (CrmStaff) this.sessionGet("loginUser"); 
		this.getModel().setCrmStaff(crmStaff);
		this.getModel().setCreateDate(new Date());
		//如果不退款，就没有退款金额
		if(CommonConstant.RUNOFF_REFUND_NOT.equals(this.getModel().getIsRefund())){
			this.getModel().setRefundAmount("");
		}
		
		this.getRunOffService().addRunoff(this.getModel());
		
		return "add";
	}
	
	/**
	 * 查询所有
	 * @return
	 */
	public String findAll(){
		List<CrmRunOff> allRunOff = this.getRunOffService().findAll();
		this.set("allRunOff", allRunOff);
		
		return "findAll";
	}

}
