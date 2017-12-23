package com.cskaoyan.crm.graduate.domain;

import java.util.Date;

import com.cskaoyan.crm.student.domain.CrmStudent;

/**
 * 学生就业信息(毕业生)
 * @author Administrator
 *
 */
public class CrmGraduate implements java.io.Serializable {

	private static final long serialVersionUID = 427123559718907186L;
	
	
	private String granduateId;
	//一对一： 一条就业信息  对应 一个学生
	private CrmStudent crmStudent;	//学生
	private String companyName;		//公司名称			
	private String salary;			//薪资
	
	private String post;			//岗位
	private Date entryTime;			//入职时间
	private String remark;			//描述
	
	
	public String getGranduateId() {
		return granduateId;
	}
	public void setGranduateId(String granduateId) {
		this.granduateId = granduateId;
	}
	public CrmStudent getCrmStudent() {
		return crmStudent;
	}
	public void setCrmStudent(CrmStudent crmStudent) {
		this.crmStudent = crmStudent;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public Date getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	

}