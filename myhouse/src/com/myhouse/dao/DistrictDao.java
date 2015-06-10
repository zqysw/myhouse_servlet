package com.myhouse.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myhouse.entity.District;


public class DistrictDao extends BaseDao{
	/**
	 * selAllDistrict()方法是返回所有街区信息
	 * @return 返回一个街区的list集合
	 */
	public List<District> selAllDistrict() {
		List<District> list = new ArrayList<District>();
		String sql = "select * from district order by id desc";
		ResultSet rs = super.exeQuery(sql, null);
		try {
			while (rs.next()) {
				District district = new District();
				district.setId(rs.getInt("id"));
				district.setName(rs.getString("name"));
				list.add(district);
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
	 * selDistrictById(int id)方法是通过街区id值查询对应的街区信息
	 * @param id 需查询的街区id
	 * @return 返回一个街区对象
	 * 查询数据库，最后一定要关闭资源
	 */
	public District selDistrictById(int id){
		District dis = null;
		String sql = "select * from district where id = ?";
		Object [] values = {id};
		ResultSet rs = super.exeQuery(sql, values);
		try {
			while(rs.next()){
				dis = new District();
				dis.setId(rs.getInt("id"));
				dis.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			super.closeAll();
		}
		return dis;
	}
}
