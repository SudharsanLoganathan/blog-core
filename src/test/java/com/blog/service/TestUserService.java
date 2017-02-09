package com.blog.service;

import com.blog.exception.ServiceException;
import com.blog.model.UserDetail;

public class TestUserService {

	public static void main(String[] args) {
		UserService userService=new UserService();
		UserDetail userDetail=new UserDetail();
		userDetail.setEmailId("sudhar");
		userDetail.setPassword("sai");
		try{
			userService.serviceLogin(userDetail);
		}
		catch(ServiceException e){
			e.printStackTrace();
		}
	}

}
