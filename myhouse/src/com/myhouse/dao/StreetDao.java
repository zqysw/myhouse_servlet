package com.myhouse.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myhouse.entity.HouseType;
import com.myhouse.entity.Street;

public class StreetDao extends BaseDao {
	/**
	 * selStreet()方法获得所有街道
	 * @return 街道对象的list集合
	 */
	public List<Street> selStreet() {
		List<Street> list = new ArrayList<Street>();
		String sql = "select * from street order by id desc";
		ResultSet rs = super.exeQuery(sql, null);
		try {
			while (rs.next()) {
				Street str = new Street();
				str.setId(rs.getInt("id"));
				str.setName(rs.getString("name"));
				list.add(str);
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
	 * selStreetById(int id)方法通过街道id来获得其对应的街道对象
	 * @param id 要查的街道id
	 * @return 一个 街道对象
	 */
	public Street selStreetById(int id){
		Street str = null;
		String sql = "select * from street where id = ?";
		Object [] values = {id};
		ResultSet rs = super.exeQuery(sql, values);
		try {
			while(rs.next()){
				str = new Street();
				str.setId(rs.getInt("id"));
				str.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
}
