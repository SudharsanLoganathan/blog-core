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
	public UserDetail serviceLogin(UserDetail user) throws ServiceException {
		UserDetailDAO userDetailDAO = new UserDetailDAO();
		try {
			Integer idByEmail=userDetailDAO.getIdByEI(user.getEmailId()).getId();
			Integer idByPassword=userDetailDAO.getIdByPW(user.getPassword()).getId();
			return userDetailDAO.checkUser(idByEmail, idByPassword);
		} 
		catch (Exception e) {
			throw new ServiceException("Invalid EmailId/Password",e);
		}
	
	}


	public List<UserDetail> serviceListAllUsers() {
		UserDetailDAO userDetailDAO = new UserDetailDAO();
		return userDetailDAO.list();
	}
	
}

