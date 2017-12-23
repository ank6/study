package com.cskaoyan.crm.post.domain;

import java.util.HashSet;
import java.util.Set;

import com.cskaoyan.crm.department.domain.CrmDepartment;
import com.cskaoyan.crm.staff.domain.CrmStaff;
/**
 * 职务
 * @author Administrator
 *
 */
public class CrmPost implements java.io.Serializable {

	private static final long serialVersionUID = 7450601268819635385L;
	
	private String postId;
	private String postName;				//职务名称
	private CrmDepartment crmDepartment;	//所属部门
	
	//一对多：一个职务 有 【多个员工】 任职
	private Set<CrmStaff> crmStaffSet = new HashSet<CrmStaff>();

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public CrmDepartment getCrmDepartment() {
		return crmDepartment;
	}

	public void setCrmDepartment(CrmDepartment crmDepartment) {
		this.crmDepartment = crmDepartment;
	}

	public Set<CrmStaff> getCrmStaffSet() {
		return crmStaffSet;
	}

	public void setCrmStaffSet(Set<CrmStaff> crmStaffSet) {
		this.crmStaffSet = crmStaffSet;
	}
	
	
	

	
}