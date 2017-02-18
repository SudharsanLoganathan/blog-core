package com.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.RoleDAO;
import com.blog.exception.RoleInvalidException;
import com.blog.exception.ServiceException;
import com.blog.model.Role;
import com.blog.validator.RoleValidator;

@Service
public class RoleService {
	@Autowired
	RoleValidator roleValidator= new RoleValidator();
	@Autowired
	RoleDAO roleDAO = new RoleDAO();
	public void serviceSave(Role role) throws ServiceException
	{
		try {
			roleValidator.validateSave(role);
			roleDAO.save(role);
		} catch (RoleInvalidException e) {
			throw new ServiceException(e.getMessage(),e);
		}
	}
	public void serviceUpdate(Role role) throws ServiceException
	{
		
		try {
			roleValidator.validateUpdate(role);
			roleDAO.update(role);
		} catch (RoleInvalidException e) {
			throw new ServiceException(e.getMessage(),e);
		}
	}
	public void serviceDelete(Role role) throws ServiceException
	{
		
		try {
			roleValidator.validateDelete(role);
			roleDAO.delete(role);
		} catch (RoleInvalidException e) {
			throw new ServiceException(e.getMessage(),e);
		}
	}
	
	public void servicListAllRoles()
	{
		roleDAO.list();
	}
}
