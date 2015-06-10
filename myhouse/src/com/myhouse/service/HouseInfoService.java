package com.myhouse.service;

import java.util.List;

import com.myhouse.dao.HouseInfoDao;
import com.myhouse.entity.HouseInfo;

public class HouseInfoService {
	HouseInfoDao dao = new HouseInfoDao();

	public int addHouse(HouseInfo house) {
		int result = -2;
		boolean istrue = dao.selHouseByTitle(house.getTitle());
		if (istrue == false) {
			result = dao.addHouse(house);
		} else {
			result = -1;
		}
		return result;
	}
	/**
	 * 删除某条信息。
	 * @param id是要删除的信息的id
	 * @return
	 */
	public int delHouse(int id) {
		int result = -2;
		boolean istrue = dao.selHouseById(id);
		if (istrue == true) {
		
			result = dao.delHouseById(id);
		
		} else {
			result = -1;
		}
		return result;
	}
	public List<HouseInfo> selAllHouse() {
		return dao.selAllHouse();
	}
	public List<HouseInfo> selHousesByPage(int pageindex,int pagesize) {
		return dao.selHousesByPage(pageindex, pagesize);
	}
	public List<HouseInfo> selHousesByKey(int pageindex,int pagesize,String key) {
		return dao.selHousesByPage(pageindex, pagesize, key);
	}
	public List<HouseInfo> search(int pageindex,int pagesize,int low_price,int high_price,String title,String type_id,String street_id,int low_floorage,int high_floorage) {
		return dao.search(pageindex, pagesize, low_price, high_price, title, type_id, street_id, low_floorage, high_floorage);
	}
	public List<HouseInfo> selHousesByName(String name,int pageindex,int pagesize) {
		return dao.selHousesByName(name,pageindex, pagesize);
	}
	public String selHouseTypeById(int id) {
		return dao.selHouseTypeNameById(id);
	}

	public String selDistrictTypeById(int id) {
		return dao.selDistrictNameById(id);
	}

	public String selStreetTypeById(int id) {
		return dao.selStreetNameById(id);
	}
	public int getPageCount(int pagesize){
		int count = -1;
		int housecount = dao.selHouseCount();
		if(housecount%pagesize ==0){
			count = housecount/pagesize;
		}else{
			count =  housecount/pagesize+1;
		}
		return count;
		
	}
	public int getPageCountByKey(int pagesize,String key){
		int count = -1;
		int housecount = dao.selHouseCount(key);
		if(housecount%pagesize ==0){
			count = housecount/pagesize;
		}else{
			count =  housecount/pagesize+1;
		}
		return count;
		
	}
	/**
	 * 根据所有条件搜索房子数量
	 * @param pagesize
	 * @param key
	 * @return
	 */
	public int getPageCountByAll(int pagesize,int low_price,int high_price,String title,String type_id,String street_id,int low_floorage,int high_floorage){
		int count = -1;
		int housecount = dao.selHouseCountByAll(low_price, high_price, title, type_id, street_id, low_floorage, high_floorage);
		if(housecount%pagesize ==0){
			count = housecount/pagesize;
		}else{
			count = housecount/pagesize+1;
		}
		return count;
		
	}
	public int getPageCountByName(int pagesize, String name){
		int count = -1;
		int housecount = dao.selHouseCountByName(name);
		if(housecount%pagesize ==0){
			count = housecount/pagesize;
		}else{
			count =  housecount/pagesize+1;
		}
		return count;
	}
	public int editHouse(HouseInfo house){
		return dao.UpdateHouse(house);
	}
	public HouseInfo selHouseByID(int id){
		return dao.selHouseByHD(id);
	}
}
