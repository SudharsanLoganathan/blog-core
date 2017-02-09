package com.blog.validator;

import com.blog.exception.ArticleCatagoryInvalidException;
import com.blog.model.ArticleCatagory;

public class ArticleCatagoryValidator {

	public void validateSave(ArticleCatagory articleCatagory) throws ArticleCatagoryInvalidException {
		if (articleCatagory.getArticleId().getId() < 0) {
			throw new ArticleCatagoryInvalidException("Invalid Article ID");
		} else if (articleCatagory.getCatagoryId().getId() < 0) {
			throw new ArticleCatagoryInvalidException("Invalid catagory ID");
		}
	}

	public void validateUpdate(ArticleCatagory articleCatagory) throws ArticleCatagoryInvalidException {
		if (articleCatagory.getArticleId().getId() < 0) {
			throw new ArticleCatagoryInvalidException("Invalid Article ID");
		} else if (articleCatagory.getCatagoryId().getId() < 0) {
			throw new ArticleCatagoryInvalidException("Invalid category ID");
		}
	}

	public void validateDelete(ArticleCatagory articleCatagory) throws ArticleCatagoryInvalidException {
		if (articleCatagory.getArticleId().getId() < 0) {
			throw new ArticleCatagoryInvalidException("Invalid Article ID");
		}
	}
}
