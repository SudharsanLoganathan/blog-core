package com.blog.model;

import lombok.Data;

@Data
public class Comment {
	private Integer id;
	private Article articleId;
	private UserDetail userId;
	private String comments;
}
