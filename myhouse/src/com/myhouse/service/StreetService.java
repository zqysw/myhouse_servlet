package com.myhouse.service;

import java.util.List;

import com.myhouse.dao.StreetDao;
import com.myhouse.entity.Street;

public class StreetService {
	StreetDao dao = new StreetDao();
	public List<Street> selStreet(){
		return dao.selStreet();
	}
	public Street selStreetById(int id){
		return dao.selStreetById(id);
	}
}
