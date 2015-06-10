package com.myhouse.service;

import com.myhouse.dao.FileInfoDao;
import com.myhouse.entity.FileInfo;

public class FileInfoService {
	FileInfoDao dao = new FileInfoDao();
	public int insertFile(FileInfo fileinfo){
		return dao.insertFile(fileinfo);
	}
}
