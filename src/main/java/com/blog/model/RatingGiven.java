package com.blog.model;

import lombok.Data;

@Data
public class RatingGiven {
	private Integer id;
	private UserDetail userId;
	private Article articleId;
	private Integer ratings;
	private boolean like;
}
