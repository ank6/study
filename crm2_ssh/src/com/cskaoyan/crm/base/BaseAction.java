package com.cskaoyan.crm.base;

import java.lang.reflect.ParameterizedType;

import com.cskaoyan.crm.classesm.service.ClassService;
import com.cskaoyan.crm.coursetype.service.CourseTypeService;
import com.cskaoyan.crm.department.service.DepartmentService;
import com.cskaoyan.crm.follow.service.FollowService;
import com.cskaoyan.crm.graduate.service.GraduateService;
import com.cskaoyan.crm.post.service.PostService;
import com.cskaoyan.crm.refer.service.ReferService;
import com.cskaoyan.crm.runoff.service.RunOffService;
import com.cskaoyan.crm.staff.service.StaffService;
import com.cskaoyan.crm.station.service.StationService;
import com.cskaoyan.crm.student.service.StudentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {
	
	//0 获得泛型 Class
	private Class<T> beanClass;
	
	@SuppressWarnings("unchecked")
	public BaseAction() {
		try {
			//1 获得封装数据javabean字节码
			ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
			beanClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
			
			//2 创建 javabean实例  new T()
			t = beanClass.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	//1 封装数据：登录数据、编辑前id、
	private T t;
	@Override
	public T getModel() {
		return t;
	}
	//#########################################
	
	//2 需要service ，使用struts按照名称字段注入,必须提供setter
	// * 父类中private字段子类不可以使用的，需要在提供getter
	//2.1员工
	private StaffService staffService;
	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}
	public StaffService getStaffService() {
		return staffService;
	}
	
	//2.2 部门
	private DepartmentService departmentService;
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	public DepartmentService getDepartmentService() {
		return departmentService;
	}
	//2.3 职务
	private PostService postService;
	public void setPostService(PostService postService) {
		this.postService = postService;
	}
	public PostService getPostService() {
		return postService;
	}
	// 2.4 课程类别
	private CourseTypeService courseTypeService;
	public void setCourseTypeService(CourseTypeService courseTypeService) {
		this.courseTypeService = courseTypeService;
	}
	public CourseTypeService getCourseTypeService() {
		return courseTypeService;
	}
	// 2.5 班级
	private ClassService classService;
	public void setClassService(ClassService classService) {
		this.classService = classService;
	}
	public ClassService getClassService() {
		return classService;
	}
	
	// 2.6 咨询
	private ReferService referService;
	public void setReferService(ReferService referService) {
		this.referService = referService;
	}
	public ReferService getReferService() {
		return referService;
	}
	
	// 2.7 跟踪
	private FollowService followService;
	public void setFollowService(FollowService followService) {
		this.followService = followService;
	}
	public FollowService getFollowService() {
		return followService;
	}
	
	// 2.8 学生
	private StudentService studentService;
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public StudentService getStudentService() {
		return studentService;
	}
	
	// 2.9 升级/转班
	private StationService stationService;
	public void setStationService(StationService stationService) {
		this.stationService = stationService;
	}
	public StationService getStationService() {
		return stationService;
	}
	
	// 2.10 丢失
	private RunOffService runOffService;
	public void setRunOffService(RunOffService runOffService) {
		this.runOffService = runOffService;
	}
	public RunOffService getRunOffService() {
		return runOffService;
	}
	
	// 2.11 就业
	private GraduateService graduateService;
	public void setGraduateService(GraduateService graduateService) {
		this.graduateService = graduateService;
	}
	public GraduateService getGraduateService() {
		return graduateService;
	}
	
	//3.1 获得当前页
	private int pageNum = 1;
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageNum() {
		return pageNum;
	}
	//3.2 每页显示个数（固定值）
	private int pageSize = 2;
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageSize() {
		return pageSize;
	}
	
	//4 提供公共方法，方便操作
	// 4.1 给 context赋值
	public void put(String key ,Object value){
		ActionContext.getContext().put(key, value);
	}
	// 4.2 给session赋值
	public void sessionPut(String key,Object value){
		ActionContext.getContext().getSession().put(key, value);
	}
	// 4.3 给session赋值
	public void applicationPut(String key,Object value){
		ActionContext.getContext().getApplication().put(key, value);
	}
	
	// 4.4 给 root 值栈设置
	public void set(String key ,Object value){
		ActionContext.getContext().getValueStack().set(key, value);
	}
	
	// 4.5 给 root值栈 压栈
	public void push(Object o){
		ActionContext.getContext().getValueStack().push(o);
	}
	// 4.6 给 root值栈 压栈
	public Object get(String o){
		return ActionContext.getContext().get(o);
	}
	public Object sessionGet(String o){
		return ActionContext.getContext().getSession().get(o);
	}
	public Object applicationGet(String o){
		return ActionContext.getContext().getApplication().get(o);
	}
	
	
	
	
}
