package com.cskaoyan.crm.classesm.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.cskaoyan.crm.coursetype.domain.CrmCourseType;
import com.cskaoyan.crm.graduate.domain.CrmGraduate;
import com.cskaoyan.crm.station.domain.CrmStation;
import com.cskaoyan.crm.student.domain.CrmStudent;

/**
 * 班级管理
 * @author Administrator
 */
public class CrmClass implements java.io.Serializable {

	private static final long serialVersionUID = -6412775832959370116L;
	private String classId;
	private CrmCourseType crmCourseType;
	
	private String name;
	private Date beginTime;
	private Date endTime;
	
	private String status;			//状态（未开课/已开课/已结束）
	private int totalCount;		//学生总数
	private int upgradeCount;	//升学数
	private int changeCount;	//转班数
	private int runoffCount;	//退费数
	private String remark;
	
	private String uploadPath;		//课表(schedule)路径
	private String uploadFilename;	//上传文件名称
	private Date uploadTime;		//长传时间
	
	//从当前升级或转班 所有记录
	private Set<CrmStation> crmBeforeStationSet = new HashSet<CrmStation>();
	//升级/转班 到 当前班
	private Set<CrmStation> crmAfterStationSet = new HashSet<CrmStation>();
	//就业
	private Set<CrmGraduate> crmGraduateSet = new HashSet<CrmGraduate>();	
	//学生
	private Set<CrmStudent> crmStudentSet = new HashSet<CrmStudent>();
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public CrmCourseType getCrmCourseType() {
		return crmCourseType;
	}
	public void setCrmCourseType(CrmCourseType crmCourseType) {
		this.crmCourseType = crmCourseType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getUpgradeCount() {
		return upgradeCount;
	}
	public void setUpgradeCount(int upgradeCount) {
		this.upgradeCount = upgradeCount;
	}
	public int getChangeCount() {
		return changeCount;
	}
	public void setChangeCount(int changeCount) {
		this.changeCount = changeCount;
	}
	public int getRunoffCount() {
		return runoffCount;
	}
	public void setRunoffCount(int runoffCount) {
		this.runoffCount = runoffCount;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Set<CrmStation> getCrmBeforeStationSet() {
		return crmBeforeStationSet;
	}
	public void setCrmBeforeStationSet(Set<CrmStation> crmBeforeStationSet) {
		this.crmBeforeStationSet = crmBeforeStationSet;
	}
	public Set<CrmStation> getCrmAfterStationSet() {
		return crmAfterStationSet;
	}
	public void setCrmAfterStationSet(Set<CrmStation> crmAfterStationSet) {
		this.crmAfterStationSet = crmAfterStationSet;
	}
	public Set<CrmGraduate> getCrmGraduateSet() {
		return crmGraduateSet;
	}
	public void setCrmGraduateSet(Set<CrmGraduate> crmGraduateSet) {
		this.crmGraduateSet = crmGraduateSet;
	}
	public Set<CrmStudent> getCrmStudentSet() {
		return crmStudentSet;
	}
	public void setCrmStudentSet(Set<CrmStudent> crmStudentSet) {
		this.crmStudentSet = crmStudentSet;
	}
	public String getUploadPath() {
		return uploadPath;
	}
	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}
	public Date getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}
	public String getUploadFilename() {
		return uploadFilename;
	}
	public void setUploadFilename(String uploadFilename) {
		this.uploadFilename = uploadFilename;
	}
	
	
}
	