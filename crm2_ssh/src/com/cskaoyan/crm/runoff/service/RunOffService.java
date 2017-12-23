package com.cskaoyan.crm.runoff.service;

import java.util.List;

import com.cskaoyan.crm.runoff.domain.CrmRunOff;

public interface RunOffService {

	void addRunoff(CrmRunOff crmRunOff);

	List<CrmRunOff> findAll();


}
