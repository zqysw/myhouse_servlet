package com.myhouse.service;

import com.myhouse.dao.UserDao;
import com.myhouse.entity.User;

public class UserService {
	UserDao dao = new UserDao();
	public boolean selUser(User user) {
		
		User us1 = dao.selUserByName(user.getName());
		if (us1 != null) {
			if (us1.getPassword().equals(user.getPassword())) {
				return true;
			} else {
				return false;
			}
		}else{
			return false;
		}
	}
	public boolean selUserIsTrue(String name) {
		
		boolean result = dao.selUserIsTrue(name);
		return result;
	}
	public User getUser(String name){
		UserDao dao = new UserDao();
		return dao.selUserByName(name);
	}
	
	public int addUser(User user){
		int result = -2;
		User ustest = dao.selUserByName(user.getName()) ;
		if(ustest ==null){
			result = dao.addUser(user);
		}else{
			result = -1;
		}
		return result;
	}
	
}
