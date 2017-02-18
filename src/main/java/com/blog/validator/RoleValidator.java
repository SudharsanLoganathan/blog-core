package com.blog.validator;

import org.springframework.stereotype.Repository;

import com.blog.exception.RoleInvalidException;
import com.blog.model.Role;

@Repository
public class RoleValidator {
	public void validateSave(Role role) throws RoleInvalidException
	{
		if(role.getId()<0)
		{
			throw new RoleInvalidException("Invalid Role ID");
		}
		else if(role.getName()==null||"".equals(role.getName().trim()))
		{
			throw new RoleInvalidException("Invalid Role Name");

		}
	}
	public void validateUpdate(Role role) throws RoleInvalidException
	{
		if(role.getId()<0)
		{
			throw new RoleInvalidException("Invalid Role ID");
		}
		else if(role.getName()==null||"".equals(role.getName().trim()))
		{
			throw new RoleInvalidException("Invalid Role Name");

		}
	}
	public void validateDelete(Role role) throws RoleInvalidException
	{
		if(role.getId()<0)
		{
			throw new RoleInvalidException("Invalid Role ID");
		}
		
	}
}
