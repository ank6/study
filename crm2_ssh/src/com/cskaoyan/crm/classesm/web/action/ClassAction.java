package com.cskaoyan.crm.classesm.web.action;

import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.cskaoyan.crm.base.BaseAction;
import com.cskaoyan.crm.classesm.domain.CrmClass;
import com.cskaoyan.crm.constant.CommonConstant;
import com.cskaoyan.crm.coursetype.domain.CrmCourseType;
import com.cskaoyan.crm.utils.StringUtils;

public class ClassAction extends BaseAction<CrmClass> {

	private static final long serialVersionUID = 7109237028679527218L;
	
	/**
	 * 查询所有
	 * @return
	 */
	public String findAll(){
		List<CrmClass> allClass = this.getClassService().findAll();
		this.set("allClass", allClass);
		return "findAll";
	}
	
	/**
	 * 添加或更新 前
	 * @return
	 */
	public String preAddOrEdit(){
		//1 查询班级
		if(this.getModel().getClassId() != null){
			CrmClass findClass = this.getClassService().findById(this.getModel().getClassId());
			this.push(findClass);
		}
		//2 查询类别
		List<CrmCourseType> allCourseType = this.getCourseTypeService().findAll();
		this.set("allCourseType", allCourseType);
		return "preAddOrEdit";
	}
	/**
	 * 添加或更新 
	 * @return
	 */
	public String addOrEdit(){
		
		CrmClass model = this.getModel();
		System.out.println("ClassAction.addOrEdit()"+model);
		this.getClassService().addOrEdit(this.getModel());
		return "addOrEdit";
	}
	/**
	 * 通过id查询
	 * @return
	 */
	public String findById(){
		CrmClass findClass = this.getClassService().findById(this.getModel().getClassId());
		this.push(findClass);
		return "findById";
	}
	
	/**
	 * 通过课程类别id查询所有的班级
	 * @return
	 */
	public String ajaxGetClass(){
		List<CrmClass> allClass = this.getClassService().findAll(this.getModel().getCrmCourseType());
		this.put("allClass", allClass);
		return "ajaxGetClass";
	}
	
	/**
	 * 上传前
	 * @return
	 */
	public String preUpload(){
		CrmClass findClass = this.getClassService().findById(this.getModel().getClassId());
		this.push(findClass);
		return "preUpload";
	}
	
	// 上传
	private File schedule;
	private String scheduleFileName;
	public void setSchedule(File schedule) {
		this.schedule = schedule;
	}
	public void setScheduleFileName(String scheduleFileName) {
		this.scheduleFileName = scheduleFileName;
	}
	/**
	 * 上传
	 * @return
	 */
	public String upload(){
		
		try {
			//将上传内容保存到指定位置
			String parentDir = ServletActionContext.getServletContext().getRealPath(CommonConstant.CLASS_SCHEDULE_DIR);
			String randomName = StringUtils.getUUID();
			File target = new File(parentDir, randomName);
			FileUtils.copyFile(schedule, target);
			
			//设置路径
			this.getModel().setUploadPath(CommonConstant.CLASS_SCHEDULE_DIR + "/" + randomName);
			this.getModel().setUploadFilename(scheduleFileName);
			
			this.getClassService().updateSchedule(this.getModel());
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
			this.addFieldError("uploadTime", "上传有误" + e.getMessage());
			return "input";
		}
		return "upload";
	}

	/**
	 * 下载
	 * @return
	 */
	public String download(){
		CrmClass findClass = this.getClassService().findById(this.getModel().getClassId());
		InputStream is = ServletActionContext.getServletContext().getResourceAsStream(findClass.getUploadPath());
		if(is == null){
			this.addFieldError("uploadFilename", "课表已经不存在，请重新上传");
			return "input";
		}
		this.target = is;
		this.downloadFileName = findClass.getUploadFilename();
		
		return "download";
	}
	private InputStream target;
	public InputStream getTarget() {
		return target;
	}
	private String downloadFileName;
	public String getDownloadFileName() throws UnsupportedEncodingException {
		if(downloadFileName != null){
			return new String(downloadFileName.getBytes(),"ISO-8859-1");
		}
		return downloadFileName;
	}
	
	
	
	
	
}
