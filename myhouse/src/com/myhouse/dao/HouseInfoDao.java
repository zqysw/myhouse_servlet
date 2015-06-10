package com.myhouse.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myhouse.myhouseUtils.*;
import com.myhouse.entity.District;
import com.myhouse.entity.HouseInfo;
import com.myhouse.entity.HouseType;
import com.myhouse.entity.Street;

public class HouseInfoDao extends BaseDao {
	/**
	 * selHouseTypeNameById(int id)方法通过房屋id查询其对应的值。
	 * @param id 需查询的房屋id
	 * @return 返回房屋id对应的房屋类型名
	 * 数据库查询最后要关闭资源。
	 */
	public String selHouseTypeNameById(int id) {
		HouseType ht = null;
		String sql = "select name from type where id = ?";
		Object[] values = { id };
		ResultSet rs = super.exeQuery(sql, values);
		try {
			if (rs.next()) {
				ht = new HouseType();
				ht.setId(id);
				ht.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			super.closeAll();
		}
		String result = ht.getName();
		return result;
	}
	/**
	 * selDistrictNameById(int id)方法查询街区id对应的街区名
	 * @param id 需查询的街区id
	 * @return 街区名
	 */
	public String selDistrictNameById(int id) {
		District dis = null;

		String sql = "select name from district where id = ?";
		Object[] values = { id };
		ResultSet rs = super.exeQuery(sql, values);
		try {
			if (rs.next()) {
				dis = new District();
				dis.setId(id);
				dis.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			super.closeAll();
		}
		String result = dis.getName();
		return result;
	}
	/**
	 * selStreetNameById(int id)方法查询街道id对应的街道名
	 * @param id
	 * @return
	 */
	public String selStreetNameById(int id) {
		Street street = null;
		String sql = "select name from street where id = ?";
		Object[] values = { id };
		ResultSet rs = super.exeQuery(sql, values);
		try {
			if (rs.next()) {
				street = new Street();
				street.setId(id);
				street.setName(rs.getString("name"));   //rs.getString("name")是读取数据库中对应name一列的值
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			super.closeAll();
		}
		String result = street.getName();
		return result;
	}
	/**
	 * addHouse(HouseInfo house)方法添加发布的房屋信息
	 * @param house 需添加的房屋对象
	 * @return 影响行数
	 */
	public int addHouse(HouseInfo house) {
		int result = -2;
		String sql = "insert into houseinfo(title,housetype,floorage,price,housedate,district_id,street_id,phone,content,owner) "
				+ "values(?,?,?,?,?,?,?,?,?,?)";
		//数据库中存的日期对象是string，所以需先转为string型
		String housedatetest = Datechange.getStrByDate(house.getHousedate(),
				"yyyy-MM-dd");
		Object[] values = { house.getTitle(), house.getHousetype(),
				house.getFloorage(), house.getPrice(), housedatetest,
				house.getDistrict_id(), house.getStreet_id(),
				house.getContact(), house.getContent(),house.getOwner() };
		result = super.exeUpdate(sql, values);
		return result;
	}
	/**
	 * delHouseById(int delId)方法通过房屋id来删除对象。
	 * @param delId 需删除的房屋id。
	 * @return 返回影响行数。
	 */
	public int delHouseById(int delId) {
		int result = -2;
		String sql = "delete from houseinfo where id = ?";
		Object[] values = {delId };
		result = super.exeUpdate(sql, values);
		return result;
	}
	/**
	 * selHouseByTitle(String title)方法为通过title判断数据库中是否已有某房屋信息
	 * @param title 要查询的title
	 * @return 返回是否已存在的boolean值。
	 */
	public boolean selHouseByTitle(String title) {
		boolean result = false;
		String sql = "select * from houseinfo where title = ?";  //？是出于安全性考虑
		Object[] values = { title };
		ResultSet rs = super.exeQuery(sql, values);
		try {
			if (rs.next()) {
				result = true;
			} else {
				result = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			super.closeAll();
		}
		return result;
	}
	/**
	 * selHouseById(int id)方法通过id值来查找房屋信息
	 * @param id 要查找的房屋id
	 * @return 是否找到的boolean值。
	 */
	public boolean selHouseById(int id) {
		boolean result = false;
		String sql = "select * from houseinfo where id = ?";
		Object[] values = { id };
		ResultSet rs = super.exeQuery(sql, values);
		try {
			if (rs.next()) {
			
				result = true;
			} else {
				result = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			super.closeAll();
		}
		return result;
	}
	/**
	 * 这是根据id值返回一个houseinfo对象。
	 * @param id 传入的房屋id。
	 * @return  返回一个houseinfo的对象。
	 */
	public HouseInfo selHouseByHD(int id) {
		HouseInfo house = null;
		String sql = "select * from houseinfo where id = ?";
		Object[] values = { id };
		
		ResultSet rs = super.exeQuery(sql, values);
		try {
			if (rs.next()) {
				house = new HouseInfo();
				house.setContact(rs.getString("phone"));
				house.setContent(rs.getString("content"));
				house.setDistrict_id(rs.getInt("district_id"));
				house.setFloorage(rs.getString("floorage"));
				house.setHousedate(rs.getDate("housedate"));
				house.setHousetype(rs.getInt("housetype"));
				house.setPrice(rs.getString("price"));
				house.setStreet_id(rs.getInt("street_id"));
				house.setTitle(rs.getString("title"));
				house.setOwner(rs.getString("owner"));
				house.setId(rs.getInt("id"));
				
			} else {
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			super.closeAll();
		}
		return house;
	}
	/**
	 * selAllHouse()方法是获得所有房屋
	 * @return 返回房屋的list集合
	 */
	public List<HouseInfo> selAllHouse() {
		List<HouseInfo> list = new ArrayList<HouseInfo>();
		String sql = "select * from houseinfo order by id desc";
		ResultSet rs = super.exeQuery(sql, null);
		try {
			while (rs.next()) {
				HouseInfo house = new HouseInfo();
				house.setContact(rs.getString("phone"));
				house.setContent(rs.getString("content"));
				house.setDistrict_id(rs.getInt("district_id"));
				house.setFloorage(rs.getString("floorage"));
				house.setHousedate(rs.getDate("housedate"));
				house.setHousetype(rs.getInt("housetype"));
				house.setPrice(rs.getString("price"));
				house.setStreet_id(rs.getInt("street_id"));
				house.setTitle(rs.getString("title"));
				house.setOwner(rs.getString("owner"));
				house.setId(rs.getInt("id"));
				list.add(house);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			super.closeAll();
		}
		return list;
	}
	/**
	 * selHousesByPage(int pageindex,int pagesize)方法按页数获取房屋
	 * @param pageindex 当前页
	 * @param pagesize  每页显示的房屋数量
	 * @return 返回house对象的list集合
	 */
	public List<HouseInfo> selHousesByPage(int pageindex,int pagesize) {
		List<HouseInfo> list = new ArrayList<HouseInfo>();
		String sql = "select * from houseinfo order by id desc limit ?,?";
		Object [] values = {(pageindex-1)*pagesize,pagesize};
		ResultSet rs = super.exeQuery(sql, values);
		try {
			while (rs.next()) {
				HouseInfo house = new HouseInfo();
				house.setContact(rs.getString("phone"));
				house.setContent(rs.getString("content"));
				house.setDistrict_id(rs.getInt("district_id"));
				house.setFloorage(rs.getString("floorage"));
				house.setHousedate(rs.getDate("housedate"));
				house.setHousetype(rs.getInt("housetype"));
				house.setPrice(rs.getString("price"));
				house.setStreet_id(rs.getInt("street_id"));
				house.setTitle(rs.getString("title"));
				house.setOwner(rs.getString("owner"));
				house.setId(rs.getInt("id"));
				list.add(house);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			super.closeAll();
		}
		return list;
	}
	/**
	 * 按页数和关键字搜索的方法，key是关键字
	 * @param pageindex 当前页
	 * @param pagesize 每页显示数目
	 * @param key 搜索关键字
	 * @return 返回house对象的list集合
	 */
	public List<HouseInfo> selHousesByPage(int pageindex,int pagesize,String key) {
		List<HouseInfo> list = new ArrayList<HouseInfo>();
		String sql = "select * from houseinfo";
		List<Object> values = new ArrayList<Object>();
		if(key!=null&&!"".equals(key)){
			sql = sql+" where title like ?";
			values.add("%"+key+"%");
		}
		sql = sql+" order by id desc limit ?,?";
		values.add((pageindex-1)*pagesize);
		values.add(pagesize);
		ResultSet rs = super.exeQuery(sql, values.toArray()); //values.toArray()方法把list集合转为数组类型。
		try {
			while (rs.next()) {
				HouseInfo house = new HouseInfo();
				house.setContact(rs.getString("phone"));
				house.setContent(rs.getString("content"));
				house.setDistrict_id(rs.getInt("district_id"));
				house.setFloorage(rs.getString("floorage"));
				house.setHousedate(rs.getDate("housedate"));
				house.setHousetype(rs.getInt("housetype"));
				house.setPrice(rs.getString("price"));
				house.setStreet_id(rs.getInt("street_id"));
				house.setTitle(rs.getString("title"));
				house.setOwner(rs.getString("owner"));
				house.setId(rs.getInt("id"));
				list.add(house);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			super.closeAll();
		}
		return list;
	}
	/**
	 * 结合所有条件的一个搜索方法
	 * @param pageindex 当前页
	 * @param pagesize 每页显示数目
	 * @param key 输入的关键字
	 * @return 返回house对象的list集合
	 */
	public List<HouseInfo> search
	(int pageindex,int pagesize,int low_price,int high_price,String title,String type_id,String street_id,int low_floorage,int high_floorage) {
		List<HouseInfo> list = new ArrayList<HouseInfo>();
		String sql = "select * from houseinfo where 1=1  ";
		List<Object> values = new ArrayList<Object>();
		if(!"".equals(title)){
			sql = sql+" and title like ?";
			values.add("%"+title+"%");
		}
		if(!"".equals(type_id)){
			int ty_id = Integer.valueOf(type_id);
			sql = sql+" and housetype = ?";
			values.add(ty_id);
		}
		if(!"".equals(street_id)){
			int str_id = Integer.valueOf(street_id);
			sql = sql+" and street_id = ?";
			values.add(str_id);
		}
		if(high_price!=0){
				sql = sql+" and price>?&&price<=? order by CAST(price AS SIGNED)";
				values.add(low_price);
				values.add(high_price);
		}
		if(low_floorage!=-1){
			sql = sql+" and floorage>?&&floorage<=? order by CAST(floorage AS SIGNED)";
			values.add(low_floorage);
			values.add(high_floorage);
		}
		sql = sql+" limit ?,?";
		values.add((pageindex-1)*pagesize);
		values.add(pagesize);
		ResultSet rs = super.exeQuery(sql, values.toArray()); //values.toArray()方法把list集合转为数组类型。
		try {
			while (rs.next()) {
				HouseInfo house = new HouseInfo();
				house.setContact(rs.getString("phone"));
				house.setContent(rs.getString("content"));
				house.setDistrict_id(rs.getInt("district_id"));
				house.setFloorage(rs.getString("floorage"));
				house.setHousedate(rs.getDate("housedate"));
				house.setHousetype(rs.getInt("housetype"));
				house.setPrice(rs.getString("price"));
				house.setStreet_id(rs.getInt("street_id"));
				house.setTitle(rs.getString("title"));
				house.setOwner(rs.getString("owner"));
				house.setId(rs.getInt("id"));
				list.add(house);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			super.closeAll();
		}
		return list;
	}
	/**
	 * selHousesByName() 按房屋发布人搜索房屋
	 * @param pageindex 当前页
	 * @param pagesize 每页房屋数目
	 * @return 返回house对象的list集合
	 */
	public List<HouseInfo> selHousesByName(String name ,int pageindex,int pagesize ) {
		List<HouseInfo> list = new ArrayList<HouseInfo>();
		String sql = "select * from houseinfo  where owner = ? order by id desc limit ?,?";
		Object [] values = {name,(pageindex-1)*pagesize,pagesize};
		ResultSet rs = super.exeQuery(sql, values);
		try {
			while (rs.next()) {
				HouseInfo house = new HouseInfo();
				house.setContact(rs.getString("phone"));
				house.setContent(rs.getString("content"));
				house.setDistrict_id(rs.getInt("district_id"));
				house.setFloorage(rs.getString("floorage"));
				house.setHousedate(rs.getDate("housedate"));
				house.setHousetype(rs.getInt("housetype"));
				house.setPrice(rs.getString("price"));
				house.setStreet_id(rs.getInt("street_id"));
				house.setTitle(rs.getString("title"));
				house.setOwner(rs.getString("owner"));
				house.setId(rs.getInt("id"));
				list.add(house);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			super.closeAll();
		}
		return list;
	}
	/**
	 * UpdateHouse(HouseInfo ht)用于修改房屋信息
	 * @param ht 要修改的房屋对象
	 * @return 返回影响行数
	 */
	public int  UpdateHouse(HouseInfo ht){
		int result = -2;
		String sql = "update houseinfo set title = ?,housetype = ?,floorage = ?, price = ?,housedate = ?" +
				",district_id =?,street_id = ?,phone = ?,content = ? ,owner = ? where id =?";
		String housedatetest = Datechange.getStrByDate(ht.getHousedate(),"yyyy-MM-dd");
		Object [] values = {ht.getTitle(),ht.getHousetype(),ht.getFloorage(),ht.getPrice(),housedatetest,ht.getDistrict_id(),
				ht.getStreet_id(),ht.getContact(),ht.getContent(),ht.getOwner(),ht.getId()};
		result = super.exeUpdate(sql, values);
		return result;	
	}
	/**
	 * selHouseCount()方法是获得搜索出来的房屋的总数量
	 * @return 返回房屋总数
	 */
	public int selHouseCount(){
		int result = -1;
		String sql = "select count(*) as num from houseinfo ";
		ResultSet rs = super.exeQuery(sql, null);
		try {
			if (rs.next()) {
				 result=rs.getInt("num");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
	return result;
	}
	/**
	 * 根据搜索条件得到搜索出来的总记录数
	 * @param key 输入的关键字
	 * @return 返回总记录数
	 */
	public int selHouseCount(String key){
		int result = -1;
		String sql = "select count(*) as num from houseinfo ";
		List values = new ArrayList();
		if(key!=null&&!"".equals(key)){
			sql = sql+" where title like ?";
			values.add("%"+key+"%");
		}
		ResultSet rs = super.exeQuery(sql, values.toArray());
		try {
			if (rs.next()) {
				 result=rs.getInt("num");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
	return result;
	}
	/**
	 * selHouseCountByAll()按所有条件得到搜索出来的房屋数量
	 * @param low_price
	 * @param high_price
	 * @param title
	 * @param type_id
	 * @param street_id
	 * @param low_floorage
	 * @param high_floorage
	 * @return 返回房屋数
	 */
	public int selHouseCountByAll(int low_price,int high_price,String title,String type_id,String street_id,int low_floorage,int high_floorage){
		int result = -1;
		String sql = "select count(*) as num from houseinfo where 1=1  ";
		List<Object> values = new ArrayList<Object>();
		if(!"".equals(title)){
			sql = sql+" and title like ?";
			values.add("%"+title+"%");
		}
		if(!"".equals(type_id)){
			int ty_id = Integer.valueOf(type_id);
			sql = sql+" and housetype = ?";
			values.add(ty_id);
		}
		if(!"".equals(street_id)){
			int str_id = Integer.valueOf(street_id);
			sql = sql+" and street_id = ?";
			values.add(str_id);
		}
		if(high_price!=0){
				sql = sql+" and price>?&&price<=? order by CAST(price AS SIGNED)";
				values.add(low_price);
				values.add(high_price);
		}
		if(low_floorage!=-1){
			sql = sql+" and floorage>?&&floorage<=? order by CAST(floorage AS SIGNED)";
			values.add(low_floorage);
			values.add(high_floorage);
		}
		ResultSet rs = super.exeQuery(sql, values.toArray());
		try {
			if (rs.next()) {
				 result=rs.getInt("num");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
	return result;
	}
	/**
	 * 根据用户名获得该用户发布的信息条数
	 * @param name
	 * @return 发布的信息条数总数
	 */
	public int selHouseCountByName(String name){
		int result = -1;

		String sql = "select count(*) as num from houseinfo where owner = ?";
		Object [] values = {name};
		ResultSet rs = super.exeQuery(sql, values);
		try {
			if (rs.next()) {
				 result=rs.getInt("num");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
	return result;
		
	}

}
