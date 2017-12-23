package com.cskaoyan.crm.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cskaoyan.crm.staff.domain.CrmStaff;
import com.cskaoyan.crm.staff.service.StaffService;

public class InitFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		String initAdmin = filterConfig.getInitParameter("initAdmin");
		if(Boolean.valueOf(initAdmin)){
			CrmStaff crmStaff = new CrmStaff();
			crmStaff.setLoginName("wd");
			crmStaff.setLoginPwd("123");
			crmStaff.setStaffName("管理员");
			
			WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(filterConfig.getServletContext());
			StaffService staffService = (StaffService) webApplicationContext.getBean("staffService");
			//查询
			CrmStaff findStaff = staffService.login(crmStaff);
			if(findStaff == null){
				//创建用户
				staffService.addStaff(crmStaff);
			}
		}
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {
		
	}

	@Override
	public void destroy() {

	}

}
