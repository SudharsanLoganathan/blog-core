package com.blog.dao;

import com.blog.model.UserDetail;

public class TestUserDetailDAO {

	public static void main(String[] args) {
		UserDetail user=new UserDetail();
		/*user.setName("SAI");
		user.setPassword("sai");
		user.setEmailId("sai@gmail.com");*/
		user.setId(1);
	UserDetailDAO dao=new UserDetailDAO();
	//dao.delete(user);
	//dao.save(user);
	System.out.println(dao.list());

	
	}

}
