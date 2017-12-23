package com.cskaoyan.crm.station.service;

import java.util.List;

import com.cskaoyan.crm.station.domain.CrmStation;

public interface StationService {

	void addStation(CrmStation crmStation);
	
	List<CrmStation> findAll();

}
