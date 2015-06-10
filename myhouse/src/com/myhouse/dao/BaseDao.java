package com.myhouse.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	private String driverClassName = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/myhouse?useUnicode = true&characterEncoding = UTF-8";
	private String name = "java3g";
	private String pwd = "java3g";
	private java.sql.Connection conn = null;
	private java.sql.PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public BaseDao() {
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
/**
 * 通用的增删改的方法
 * @param sql 用于(insert,delete,update)
 * @param values 没有的话直接传空
 * @return
 */
	public int exeUpdate(String sql, Object[] values) {
		int result = 0;
		try {
			conn = DriverManager.getConnection(url, name, pwd);
			pstmt = conn.prepareStatement(sql);
			if (values != null) {
				for (int i = 0; i < values.length; i++) {
					pstmt.setObject(i + 1, values[i]);
				}
			}
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll();
			
			}
		return result;
		}
	/**
	 * 通用的查询的方法
	 * @param sql 用于(select)
	 * @param values 没有的话直接传空
	 * @return 一定要在外面关闭资源
	 */
		public ResultSet exeQuery(String sql, Object[] values) {
			try {
				conn = DriverManager.getConnection(url, name, pwd);
				pstmt = conn.prepareStatement(sql);
				if (values != null) {
					for (int i = 0; i < values.length; i++) {
						pstmt.setObject(i + 1, values[i]);
					}
				}
				rs = pstmt.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				//在查询这不能关闭资源，要在外面关闭，否则读不出数据了。
				
				}
			return rs;
			}
		public void closeAll(){
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
		
	
