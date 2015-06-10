package com.myhouse.service;

import java.util.List;

import com.myhouse.dao.HouseTypeDao;
import com.myhouse.entity.HouseType;

public class HouseTypeService {
	HouseTypeDao dao = new HouseTypeDao();
	public List<HouseType> selAllType(){
		return dao.selAllHouseType();
	}
	public HouseType selHouseTypeById(int id){
		return dao.selHouseTypeById(id);
	}
}
