package com.cskaoyan.crm.staff.web.action;

import java.util.List;

import com.cskaoyan.crm.base.BaseAction;
import com.cskaoyan.crm.department.domain.CrmDepartment;
import com.cskaoyan.crm.post.domain.CrmPost;
import com.cskaoyan.crm.staff.domain.CrmStaff;
import com.cskaoyan.crm.utils.StringUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

public class StaffAction extends BaseAction<CrmStaff> {

	private static final long serialVersionUID = 3504297163246003181L;
	
	/**
	 * 登录
	 * @return
	 */
	@InputConfig(resultName="login")  //<result name="login">
	public String login(){
		
		CrmStaff model = this.getModel();
		System.out.println("StaffAction.login()"+model);
		CrmStaff loginUser = this.getStaffService().login(model);
		System.out.println("StaffAction.login()"+loginUser);
		if(loginUser != null){
			// 登录成功
			// 将用户的信息保存session中，保证一次会话数据共享
			this.sessionPut("loginUser", loginUser);
			return "success";
		} else {
			// 登录不成功
			this.addFieldError("loginName", "账号和密码不匹配");
			return "login";
		}
	}
	
	/**
	 * 查询所有用户（员工）
	 * @return
	 */
	public String findAll(){
		
		//1 查询所有部门
		List<CrmDepartment> allDepartment = this.getDepartmentService().findAll();
		this.set("allDepartment", allDepartment);
		
		//2查询所有职务
		List<CrmPost> allPost = this.getPostService().findAll();
		this.set("allPost", allPost);
		
		// 3 查询所有
		List<CrmStaff> allUser = this.getStaffService().findAll(this.getModel());
		// 将结果存放值栈中 ,jsp页面通过"key"直接获得
		this.set("allUser", allUser);
		
		return "findAll";
	}
	
	
	/**
	 * 注销重新登陆
	 * @return
	 */
	public String logout(){
		ActionContext.getContext().getSession().remove("loginUser");
		return "login";
	}
	
	/**
	 * 原始密码是否正确
	 */
	public void validateEditPassword() {
		CrmStaff loginStaff =  (CrmStaff) ActionContext.getContext().getSession().get("loginUser");
		String oldPassword = StringUtils.getMD5Value(this.getModel().getOldPassword());
		if(! loginStaff.getLoginPwd().equals(oldPassword)){
			this.addFieldError("loginName", "原始密码不正确");
		}
	}
	/**
	 * 修改密码
	 * @return
	 */
	@InputConfig(resultName="pwdInput")
	public String editPassword(){
		CrmStaff loginStaff =  (CrmStaff) this.sessionGet("loginUser");
		
		this.getStaffService().updatePassword(loginStaff.getStaffId() , this.getModel().getNewPassword());
		
		return "editPassword";
	}
	
	/**
	 * 编辑前操作：通过id查询 
	 * @return
	 */
	public String preEdit(){
		
		//1 通过id查询用户
		CrmStaff findStaff = this.getStaffService().findById(this.getModel().getStaffId());
		// 1.1 将查询结果存放值栈中，压入到栈顶，提供给struts标签进行回显的。
		// * 标签回显：<s:textfiled name="userName"/> 将使用userName从栈顶获得数据，如果获得就显示。
		ActionContext.getContext().getValueStack().push(findStaff);
		
		//2 查询所有的部门
		List<CrmDepartment> allDepartment = this.getDepartmentService().findAll();
		// 2.1 将查询结果存放到值栈中，必须设置key。jsp需要通过“#key”获得
		this.put("allDepartment", allDepartment);
		
		return "preEdit";
	}
	
	/**
	 * 编辑
	 * @return
	 */
	public String edit(){
		this.getStaffService().updateStaff(this.getModel());
		return "edit";
	}
	
	/**
	 * 添加前操作：查询所有部门
	 * @return
	 */
	public String preAdd(){
		
		//1 查询所有的部门
		List<CrmDepartment> allDepartment = this.getDepartmentService().findAll();
		// 1.1 将查询结果存放到值栈中，必须设置key。jsp需要通过“#key”获得
		this.put("allDepartment", allDepartment);
		
		return "preAdd";
	}
	/**
	 * 添加
	 * @return
	 */
	public String add(){
		CrmStaff model = this.getModel();
		System.out.println("StaffAction.add()"+model);
		this.getStaffService().addStaff(this.getModel());
		
		return "add";
	}
	
	
	
	
}
