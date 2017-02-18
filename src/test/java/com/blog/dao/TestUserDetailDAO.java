package com.blog.dao;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.blog.config.AppConfig;
import com.blog.exception.ServiceException;
import com.blog.model.UserDetail;
import com.blog.service.UserService;

public class TestUserDetailDAO {

	public static void main(String[] args) throws ServiceException {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userServiceObj  = ctx.getBean(UserService.class);
	UserDetail userDetail=new UserDetail();
	//userDetail.setName("Rahuman");
	userDetail.setEmailId("rahuman@gmail.com");
   userDetail.setPassword("rahuman");
   System.out.println(userServiceObj.serviceLogin(userDetail));

//	    userServiceObj.serviceSave(userDetail);
//		userDetail.setName("Jeffri");
//		userDetail.setPassword("aaron");
//		userServiceObj.serviceUpdate(userDetail);
//	    
	//UserDetailDAO dao=new UserDetailDAO();
	//dao.delete(user);
	//dao.save(user);
	//System.out.println(dao.list());
//System.out.println(userServiceObj.serviceListAllUsers());
	
	}

}
