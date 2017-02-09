package com.blog.service;

import com.blog.dao.RoleDAO;
import com.blog.exception.RoleInvalidException;
import com.blog.exception.ServiceException;
import com.blog.model.Role;
import com.blog.validator.RoleValidator;

public class RoleService {
	public void serviceSave(Role role) throws ServiceException
	{
		RoleValidator roleValidator= new RoleValidator();
		RoleDAO roleDAO = new RoleDAO();
		try {
			roleValidator.validateSave(role);
			roleDAO.save(role);
		} catch (RoleInvalidException e) {
			throw new ServiceException(e.getMessage(),e);
		}
	}
	public void serviceUpdate(Role role) throws ServiceException
	{
		RoleValidator roleValidator= new RoleValidator();
		RoleDAO roleDAO = new RoleDAO();
		try {
			roleValidator.validateUpdate(role);
			roleDAO.update(role);
		} catch (RoleInvalidException e) {
			throw new ServiceException(e.getMessage(),e);
		}
	}
	public void serviceDelete(Role role) throws ServiceException
	{
		RoleValidator roleValidator= new RoleValidator();
		RoleDAO roleDAO = new RoleDAO();
		try {
			roleValidator.validateDelete(role);
			roleDAO.delete(role);
		} catch (RoleInvalidException e) {
			throw new ServiceException(e.getMessage(),e);
		}
	}
	public void servicListAllRoles()
	{
		RoleDAO roleDao=new RoleDAO();
		roleDao.list();
	}
}
