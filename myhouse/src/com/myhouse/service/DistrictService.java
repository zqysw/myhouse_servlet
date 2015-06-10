package com.myhouse.service;

import java.util.List;

import com.myhouse.dao.DistrictDao;
import com.myhouse.entity.District;

public class DistrictService {
	DistrictDao dao = new DistrictDao();
	public List<District> selDistrict(){
		return dao.selAllDistrict();
		
	}
	public District selDistrictById(int id){
		return dao.selDistrictById(id);
	}
}
