package com.cskaoyan.crm.station.web.action;

import java.util.Date;
import java.util.List;

import com.cskaoyan.crm.base.BaseAction;
import com.cskaoyan.crm.coursetype.domain.CrmCourseType;
import com.cskaoyan.crm.staff.domain.CrmStaff;
import com.cskaoyan.crm.station.domain.CrmStation;
import com.cskaoyan.crm.student.domain.CrmStudent;

public class StationAction extends BaseAction<CrmStation> {

	private static final long serialVersionUID = -2154686223555693168L;
	
	/**
	 * 添加
	 * @return
	 */
	public String add(){
		this.getModel().setCreateDate(new Date());
		CrmStaff crmStaff = (CrmStaff) this.sessionGet("loginUser");
		this.getModel().setCrmStaff(crmStaff);
		
		this.getStationService().addStation(this.getModel());
		return "add";
	}
	
	/**
	 * 查询所有
	 * @return
	 */
	public String findAll(){
		List<CrmStation> allStation = this.getStationService().findAll();
		this.set("allStation", allStation);
		return "findAll";
	}
	
	/**
	 * preEditStation
	 */
	public String preEditStation(){
		//1查询所有班级类别
		List<CrmCourseType> allCourseType = this.getCourseTypeService().findAll();
		this.put("allCourseType", allCourseType);
		
		// 
		CrmStudent findStudent = this.getStudentService().findById(this.getModel().getCrmStudent().getStudentId());
		this.push(findStudent);
				
		return "preEditStation";
	}

}
