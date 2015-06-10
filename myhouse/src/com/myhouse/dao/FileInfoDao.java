package com.myhouse.dao;

import com.myhouse.entity.FileInfo;

public class FileInfoDao extends BaseDao{
	/**
	 * insertFile(FileInfo fileinfo)方法是添加文件记录信息到数据库。
	 * @param fileinfo 需添加的文件对象
	 * @return 返回影响行数
	 */
	public int insertFile(FileInfo fileinfo){
		int result =-2;
		String sql = "insert into fileinfo(filename,filepath,createtime,owner) values(?,?,now(),?)";
		Object[] values = {fileinfo.getFilename(),fileinfo.getFilepath(),fileinfo.getOwner()};
		result = super.exeUpdate(sql, values);
		return result;
		
	}
}
