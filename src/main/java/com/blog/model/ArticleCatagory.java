package com.blog.model;

import lombok.Data;

@Data
public class ArticleCatagory {
	private Integer id;
	private Article articleId;
	private SeedCatagory catagoryId;
}
