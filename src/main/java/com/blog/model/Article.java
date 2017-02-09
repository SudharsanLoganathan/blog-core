package com.blog.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data

public class Article {
	private Integer id;
	private UserDetail userId;
	private String title;
	private String content;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;
	private Boolean active;
}
