package com.blog.service;

import java.util.List;

import com.blog.dao.UserDetailDAO;
import com.blog.exception.ServiceException;
import com.blog.exception.UserInvalidException;
import com.blog.model.UserDetail;
import com.blog.validator.UserValidator;

public class UserService {
	public void serviceSave(UserDetail user) throws ServiceException {
		UserValidator userValidator = new UserValidator();
		UserDetailDAO userDetailDAO = new UserDetailDAO();

		try {
			userValidator.validateSave(user);
			userDetailDAO.save(user);
		} catch (UserInvalidException e) {
			throw new ServiceException(e.getMessage(), e);
		}

	}

	public void serviceUpdate(UserDetail user) throws ServiceException {
		UserValidator userValidator = new UserValidator();
		UserDetailDAO userDetailDAO = new UserDetailDAO();

		try {
			userValidator.validateUpdate(user);
			userDetailDAO.update(user);
		} catch (UserInvalidException e) {
			throw new ServiceException(e.getMessage(), e);
		}

	}

	public void serviceDelete(UserDetail user) throws ServiceException {
		UserValidator userValidator = new UserValidator();
		UserDetailDAO userDetailDAO = new UserDetailDAO();

		try {
			userValidator.validateDelete(user);
			userDetailDAO.delete(user);
		} catch (UserInvalidException e) {
			throw new ServiceException(e.getMessage(), e);
		}

	}
	public void serviceLogin(UserDetail user) throws ServiceException {
		UserDetailDAO userDetailDAO = new UserDetailDAO();
		try {
			Integer i=userDetailDAO.getIdByEI(user.getEmailId()).getId();
			Integer j=userDetailDAO.getIdByPW(user.getPassword()).getId();
			userDetailDAO.checkUser(i, j);
		} 
		catch (Exception e) {
			throw new ServiceException("Unable to login",e);
		}
		
	}


	public List<UserDetail> serviceListAllUsers() {
		UserDetailDAO userDetailDAO = new UserDetailDAO();
		return userDetailDAO.list();
	}
	
}

