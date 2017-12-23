package com.cskaoyan.crm.web.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
/**
 * 此拦截器必须保证用户是登录
 * * 拦截器需要注册，将自定义拦截器注册到默认拦截器栈(defaultStack)的后面
 * @author  
 *
 */
public class LoginInterceptor extends MethodFilterInterceptor {

	private static final long serialVersionUID = 840961718151554567L;

	@Override
	public String doIntercept(ActionInvocation invocation) throws Exception {
		//1 获得登录用户信息 -- session
		Object loginUser = ActionContext.getContext().getSession().get("loginUser");
		//2 判断
		if(loginUser == null){
			/** 友好提示信息 start*/
			Object action = invocation.getAction();
			if(action instanceof ActionSupport){
				ActionSupport actionSupport = (ActionSupport) action;
				actionSupport.addFieldError("logonName", "请登录");
			}
			/** 友好提示信息 end*/
			
			//没有登录
			return "nonLogin";
		}
		//3 登录 -- 放行
		return invocation.invoke();
	}

}
