package com.blog.model;

import lombok.Data;

@Data
public class UserDetail {
	private Integer id;
	private String name;
	private String password;
	private String emailId;
	private Role roleId;
}
