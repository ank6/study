package com.cskaoyan.crm.graduate.service;

import java.util.List;

import com.cskaoyan.crm.graduate.domain.CrmGraduate;

public interface GraduateService {

	List<CrmGraduate> findAll();

	void addOrEdit(CrmGraduate crmGraduate);

}
