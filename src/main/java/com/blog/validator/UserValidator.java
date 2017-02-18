package com.blog.validator;

import org.springframework.stereotype.Repository;

import com.blog.exception.UserInvalidException;
import com.blog.model.UserDetail;

@Repository
public class UserValidator {

	public void validateSave(UserDetail user) throws UserInvalidException {
		if (user.getName() == null || "".equals(user.getName().trim())) {
			throw new UserInvalidException("Invalid Name");
		} else if (user.getPassword() == null || "".equals(user.getPassword().trim())) {
			throw new UserInvalidException("Invalid Password");
		} else if (user.getEmailId() == null || "".equals(user.getEmailId().trim())) {
			throw new UserInvalidException("Invalid Email Id");
		}
	}

	public void validateUpdate(UserDetail user) throws UserInvalidException {
		if (user.getName() == null || "".equals(user.getName().trim())) {
			throw new UserInvalidException("Invalid Name");
		} else if (user.getPassword()== null || "".equals(user.getPassword().trim())) {
			throw new UserInvalidException("Invalid Password");
		}
	}

	public void validateDelete(UserDetail user) throws UserInvalidException {
		if (user.getId() < 0) {
			throw new UserInvalidException("Invalid ID");
		}
	}
public void validateUserName(UserDetail user) throws UserInvalidException{
	if (user.getName() == null || "".equals(user.getName().trim())) {
		throw new UserInvalidException("Invalid Name");
	}
	}
public void validateUser(UserDetail user) throws UserInvalidException {
	if (user.getEmailId() == null || "".equals(user.getEmailId().trim())) {
		throw new UserInvalidException("Invalid EmailID");
	} else if (user.getPassword()== null || "".equals(user.getPassword().trim())) {
		throw new UserInvalidException("Invalid Password");
	}
}

}
