package com.myhouse.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myhouse.entity.HouseInfo;
import com.myhouse.entity.HouseType;

public class HouseTypeDao extends BaseDao {
	/**
	 * selAllHouseType()方法 获得所有房屋类型
	 * @return 返回房屋类型的list集合
	 */
	public List<HouseType> selAllHouseType() {
		List<HouseType> list = new ArrayList<HouseType>();
		String sql = "select * from type order by id desc";
		ResultSet rs = super.exeQuery(sql, null);
		try {
			while (rs.next()) {
				HouseType ht = new HouseType();
				ht.setId(rs.getInt("id"));
				ht.setName(rs.getString("name"));
				list.add(ht);
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
	 * selHouseTypeById(int id)通过房屋类型id获得房屋类型的对象
	 * @param id 要查的房屋类型
	 * @return 房屋类型对象
	 */
	public HouseType selHouseTypeById(int id){
		HouseType htype = null;
		String sql = "select * from type where id = ?";
		Object []  values = {id};
		ResultSet rs=super.exeQuery(sql, values);
		try {
			while(rs.next()){
				htype = new HouseType();
				htype.setId(rs.getInt("id"));
				htype.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return htype;
	}
}
